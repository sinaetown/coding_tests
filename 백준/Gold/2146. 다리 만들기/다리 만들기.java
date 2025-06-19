import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[][] grid;
    public static int[][] marked;
    public static boolean[][] visited;

    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};

    public static int min = Integer.MAX_VALUE;

    public static class Box {
        int x;
        int y;
        int cnt;
        int land;
        int lastX;
        int lastY;

        public Box(int x, int y, int cnt, int land, int lastX, int lastY) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.land = land;
            this.lastX = lastX;
            this.lastY = lastY;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        marked = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        mark();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (marked[i][j] > 0) {
                    bfs(new boolean[n][n], new Box(i, j, 0, marked[i][j], i, j));
                }
            }
        }
        System.out.println(min);
    }

    public static int bfs(boolean[][] visited, Box start) {
        Queue<Box> queue = new ArrayDeque<>();
        visited[start.x][start.y] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            Box polled = queue.poll();
            int polledX = polled.x;
            int polledY = polled.y;
            int polledCnt = polled.cnt;
            int polledLand = polled.land;
            if (start.land != polledLand && polledLand != 0) {
                min = Math.min(polledCnt, min);
            }
            for (int k = 0; k < 4; k++) {
                int nx = polledX + dx[k];
                int ny = polledY + dy[k];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (!visited[nx][ny]) {
                        if (marked[nx][ny] == 0) { //바다를 만나면?
                            queue.add(new Box(nx, ny, polledCnt+1, marked[nx][ny], polledX, polledY));
                        } else { //그 어느 육지든 만나면?
                            queue.add(new Box(nx, ny, polledCnt, marked[nx][ny], polledX, polledY));
                        }
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return min;
    }

    public static void mark() {
        boolean[][] visited = new boolean[n][n];
        int land = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0 && !visited[i][j]) {
                    dfs(i, j, visited, land);
                    land++;
                }
            }
        }
    }

    public static void dfs(int x, int y, boolean[][] visited, int land) {
        visited[x][y] = true;
        marked[x][y] = land;
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if (grid[nx][ny] > 0 && !visited[nx][ny]) {
                    dfs(nx, ny, visited, land);
                }
            }
        }
    }
}