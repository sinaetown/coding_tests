import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int m;

    public static int[][] grid;
    public static boolean[][] visited;

    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};

    public static class Element {
        int x;
        int y;

        public Element(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int given = Integer.parseInt(st.nextToken());
                grid[i][j] = given;
            }
        }
        int years = 0;
        while (true) {
            int res = count();
            if (res >= 2) break;
            else if (res == 0) {
                years = 0;
                break;
            }
            melt();
            years++;
        }
        System.out.println(years);
    }

    public static int count() {
        boolean[][] visited = new boolean[n][m];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] > 0) {
                    dfs(i, j, visited);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void dfs(int x, int y, boolean[][] visited) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (!visited[nx][ny] && grid[nx][ny] > 0) {
                    dfs(nx, ny, visited);
                }
            }
        }
    }

    public static void melt() {
        Queue<Element> queue = new ArrayDeque<>();
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] > 0) {
                    queue.add(new Element(i, j));
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            Element polled = queue.poll();
            int water = 0;
            for (int i = 0; i < 4; i++) {
                int nx = polled.x + dx[i];
                int ny = polled.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (!visited[nx][ny] && grid[nx][ny] == 0) {
                        water++;
                    }
                }
            }
            if (grid[polled.x][polled.y] - water < 0) grid[polled.x][polled.y] = 0;
            else grid[polled.x][polled.y] -= water;
        }
    }
}