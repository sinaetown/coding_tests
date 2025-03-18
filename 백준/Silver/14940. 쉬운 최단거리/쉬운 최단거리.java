import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, 1, -1}; // up down right left
    static int[] dy = {1, -1, 0, 0};
    static int[][] grid;
    static int[][] answer;
    static int N;
    static int M;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[N][M];
        answer = new int[N][M];
        visited = new boolean[N][M];
        int x = 0, y = 0;
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                grid[n][m] = Integer.parseInt(st.nextToken());
                if (grid[n][m] == 2) {
                    x = n;
                    y = m;
                } else if (grid[n][m] == 0) {
                    visited[n][m] = true;
                }
            }
        }
        bfs(x, y);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    answer[i][j] = -1;
                }
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int[] polled = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + polled[0];
                int ny = dy[i] + polled[1];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (!visited[nx][ny] && grid[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        answer[nx][ny] = answer[polled[0]][polled[1]] + 1;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }

    }
}