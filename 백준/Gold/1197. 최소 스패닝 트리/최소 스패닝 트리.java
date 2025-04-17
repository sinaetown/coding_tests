import java.io.*;
import java.util.*;

public class Main {

    public static class Edge {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int total = 0;
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges.add(new Edge(from, to, weight));
        }
        int[] parent = new int[v + 1];
        for (int i = 1; i < v + 1; i++) {
            parent[i] = i; // 최상위 부모를 나타냄
        }

        // 간선 오름차순 정렬
        edges.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });

        int edgecnt = 0;
        // 작은 간선부터 확인
        for (int i = 0; i < edges.size(); i++) {
            // 부모가 다를 때만 확인 (사이클 확인)
            if (find(parent, edges.get(i).from) != find(parent, edges.get(i).to)) {
                total += edges.get(i).weight;
                union(parent, edges.get(i).from, edges.get(i).to);
                edgecnt++;
            }
            if (edgecnt == v - 1) break;
        }
        System.out.println(total);
    }

    public static int find(int[] parent, int i) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent, parent[i]); // 경로 압축
    }

    public static void union(int[] parent, int a, int b) {
        int parent_a = find(parent, a);
        int parent_b = find(parent, b);

        if (parent_a < parent_b) {
            parent[parent_b] = parent_a;
        } else {
            parent[parent_a] = parent_b;
        }
    }
}