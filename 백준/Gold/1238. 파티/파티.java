import java.io.*;
import java.util.*;


public class Main {
    public static class Edge {
        int node;
        int cost;

        public Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public static int[][] dp;
    public static int n;
    public static int max = -1;
    public static List<List<Edge>> graph = new ArrayList<>(); //정방향 그래프
    public static List<List<Edge>> reverse = new ArrayList<>(); //역방향 그래프

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
            reverse.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Edge(end, cost));
            reverse.get(end).add(new Edge(start, cost));
        }
        //역방향 그래프에서 x에서 출발한다는 건 결국 시작점에서 x까지 도달한다는 것
        int[] go = dijkstra(reverse, x);
        //정방향 그래프에서 x에서 출발한다는 건 결국 x에서 시작점까지 되돌아간다는 것
        int[] back = dijkstra(graph, x);
        for (int i = 1; i < n + 1; i++) {
            max = Math.max(go[i] + back[i], max);
        }
        System.out.println(max);
    }

    public static int[] dijkstra(List<List<Edge>> list, int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, 1000000000);
        dist[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        pq.add(new int[]{start, 0});
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int end = current[0];
            int cost = current[1];
            for (Edge e : list.get(end)) {
                int nextEnd = e.node;
                int nextCost = e.cost;
                if (cost + nextCost < dist[nextEnd]) {
                    dist[nextEnd] = cost + nextCost;
                    pq.add(new int[]{nextEnd, cost + nextCost});
                }
            }
        }
        return dist;
    }
}