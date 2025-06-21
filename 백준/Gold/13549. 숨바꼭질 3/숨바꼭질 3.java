import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int k;
    public static int[] visited;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new int[100001];
        Arrays.fill(visited, Integer.MAX_VALUE);
        bfs();
        System.out.println(min);
    }

    public static void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{n, 0});
        visited[n] = 0;
        while (!queue.isEmpty()) {
            int[] polled = queue.poll();
            int pos = polled[0];
            int time = polled[1];
            if (pos == k) {
                if (time < min) min = time;
            }
            if (pos + 1 <= 100000) {
                if (visited[pos + 1] > time + 1) {
                    queue.add(new int[]{pos + 1, time + 1});
                    visited[pos + 1] = time + 1;
                }
            }
            if (pos - 1 >= 0) {
                if (visited[pos - 1] > time + 1) {
                    queue.add(new int[]{pos - 1, time + 1});
                    visited[pos - 1] = time + 1;
                }
            }
            if (pos * 2 <= 100000) {
                if (visited[pos * 2] > time) {
                    queue.add(new int[]{pos * 2, time});
                    visited[pos * 2] = time;
                }
            }
        }
    }
}