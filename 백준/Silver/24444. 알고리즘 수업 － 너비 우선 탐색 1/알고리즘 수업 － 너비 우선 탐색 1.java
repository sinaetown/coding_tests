import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    static boolean[] visited;
    static List<Integer>[] edges;
    static Queue<Integer> queue = new ArrayDeque<>();
    static int[] order;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        edges = new ArrayList[N + 1];
        order = new int[N + 1];

        for (int i = 0; i < edges.length; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[a].add(b);
            edges[b].add(a);
        }
        for(List<Integer> e : edges){
            Collections.sort(e);
        }
        bfs(R);
        for (int o = 1; o < order.length; o++) {
            bw.write(order[o] + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void bfs(int R) {
        visited[R] = true;
        queue.add(R);
        int index = 1;
        while (!queue.isEmpty()) {
            int polled = queue.poll();
            order[polled] = index++;
            List<Integer> list = edges[polled];
            for (int l = 0; l < list.size(); l++) {
                int selected = list.get(l);
                if (!visited[selected]) {
                    visited[selected] = true;
                    queue.add(selected);
                }
            }
        }
    }


}