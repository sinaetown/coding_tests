import java.io.*;
import java.util.*;

public class Main {
    static Queue<Integer> queue = new ArrayDeque<>();
    static boolean[] visited = new boolean[100001];
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        bfs(N, M);
        System.out.println(answer);
    }

    public static void bfs(int N, int M) {
        visited[N] = true;
        queue.add(N);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int polled = queue.poll();
                if (polled == M) return;
                int[] next = {polled - 1, polled + 1, polled * 2};
                for (int n : next) {
                    if (n >= 0 && n <= 100000 && !visited[n]) {
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }
            answer++;
        }
    }
}