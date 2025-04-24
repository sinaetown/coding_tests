import java.io.*;
import java.util.*;

public class Main {
    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            ArrayList<Point> list = new ArrayList<>();
            for (int j = 0; j < n + 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                list.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for (int j = 0; j < n + 2; j++) {
                graph.add(new ArrayList<>());
            }
            for (int a = 0; a < n + 2; a++) {
                for (int b = a + 1; b < n + 2; b++) {
                    if (manhattan(list.get(a), list.get(b)) <= 1000) {
                        graph.get(a).add(b);
                        graph.get(b).add(a);
                    }
                }
            }
            bw.write(bfs(graph, n) ? "happy\n" : "sad\n");
        }
        bw.flush();
        bw.close();
    }

    public static boolean bfs(ArrayList<ArrayList<Integer>> graph, int n) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        boolean[] visited = new boolean[n + 2];
        visited[0] = true;
        while (!q.isEmpty()) {
            int now = q.poll();
            if (now == n + 1) {
                return true;
            }
            for (int next : graph.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
        return false;
    }

    public static int manhattan(Point a, Point b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }
}