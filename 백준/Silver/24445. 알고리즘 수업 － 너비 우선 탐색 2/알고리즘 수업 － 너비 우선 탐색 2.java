import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static List<Integer> vertices = new ArrayList<>();
    static List<Integer>[] edges;
    static Queue<Integer> queue = new ArrayDeque<>();
    static int[] order;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        edges = new ArrayList[N + 1];
        order = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[a].add(b);
            edges[b].add(a);
        }

        for (List<Integer> e : edges) {
            if (e != null) Collections.sort(e, Comparator.reverseOrder());
        }

        bfs(R);
        for (int i = 1; i <= N; i++) System.out.println(order[i]);
    }

    public static void bfs(int R) {
        int ind = 1;
        visited[R] = true;
        queue.add(R);
        while (!queue.isEmpty()) {
            int polled = queue.poll();
            order[polled] = ind++;
            List<Integer> list = edges[polled];
            for (int l = 0; l < list.size(); l++) {
                if (!visited[list.get((l))]) {
                    visited[list.get((l))] = true;
                    queue.add(list.get(l));
                }
            }
        }
    }
}