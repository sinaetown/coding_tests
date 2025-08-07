import java.io.*;
import java.util.*;

public class Main {
    public static int[][] grid;
    public static boolean[][] visited;
    public static int max = -1;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};
    public static int n;
    public static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(1, i, j, grid[i][j]);
                visited[i][j] = false;
            }
        }
        System.out.println(max);

    }

    public static void dfs(int cnt, int x, int y, int sum) {
        if (cnt == 4) {
            max = Math.max(max, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (!visited[nx][ny]) {
                    if (cnt == 2) {
                        visited[nx][ny] = true;
                        dfs(cnt + 1, x, y, sum + grid[nx][ny]);
                        visited[nx][ny] = false;
                    }
                    visited[nx][ny] = true;
                    dfs(cnt + 1, nx, ny, sum + grid[nx][ny]);
                    visited[nx][ny] = false;
                }
            }
        }
    }

}

