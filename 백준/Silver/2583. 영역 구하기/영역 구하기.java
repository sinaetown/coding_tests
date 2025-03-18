import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0}; // up down left right
    static int[] dy = {0, 0, -1, 1};
    static int[][] grid;
    static int N;
    static int M;
    static int K;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // y // 5
        N = Integer.parseInt(st.nextToken()); // x // 7
        K = Integer.parseInt(st.nextToken());
        grid = new int[M][N];
        visited = new boolean[M][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()); // 0
            int y1 = Integer.parseInt(st.nextToken()); // 2
            int x2 = Integer.parseInt(st.nextToken()); // 4
            int y2 = Integer.parseInt(st.nextToken()); // 4
            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    visited[y][x] = true;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int y = 0; y < M; y++) { //5
            for (int x = 0; x < N; x++) { //7
                if (!visited[y][x]) {
                    list.add(bfs(y, x));
                }
            }
        }
        System.out.println(list.size());
        list.sort(null);
        for (int i : list) System.out.print(i + " ");
    }

    public static int bfs(int y, int x) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{y, x});
        visited[y][x] = true;
        int cnt = 1;
        while (!queue.isEmpty()) {
            int[] polled = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + polled[1];
                int ny = dy[i] + polled[0];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (!visited[ny][nx]) {
                        cnt++;
                        visited[ny][nx] = true;
                        queue.add(new int[]{ny, nx});
                    }
                }
            }
        }
        return cnt;
    }
}