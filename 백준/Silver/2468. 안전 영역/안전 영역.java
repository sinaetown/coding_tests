import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] dx = {-1, 1, 0, 0}; // up down left right
    static int[] dy = {0, 0, -1, 1};
    static int[][] grid;
    static boolean[][] drowned;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        grid = new int[N][N];

        for (int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int m = 0; m < N; m++) {
                int num = Integer.parseInt(st.nextToken());
                if (num < min) min = num;
                if (num > max) max = num;
                grid[n][m] = num;
            }
        }

        int answer = Integer.MIN_VALUE;
        int tracker = 0;
        while (tracker <= max) {
            drowned = new boolean[N][N];
            int size = 0;
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < N; m++) {
                    if (grid[n][m] <= tracker) {
                        drowned[n][m] = true;
                    }
                }
            }
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < N; m++) {
                    if (!drowned[n][m]) {
                        size++;
                        bfs(n, m);
                    }
                }
            }
            if (size > answer) answer = size;
            tracker++;
        }
        System.out.println(answer);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        drowned[x][y] = true;
        while (!queue.isEmpty()) {
            int[] polled = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + polled[0];
                int ny = dy[i] + polled[1];
                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if (!drowned[nx][ny]) {
                        drowned[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}