import java.io.*;
import java.util.*;

public class Main {
    public static class Position {
        int x;
        int y;
        int cnt;
        boolean broke;

        public Position(int x, int y, int cnt, boolean broke) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.broke = broke;
        }
    }

    public static int[][] grid;
    public static int n;
    public static int m;
    public static int min = Integer.MAX_VALUE;
    public static boolean[][][] visited;

    public static int[] dx = {0, 0, 1, -1}; //down up right left
    public static int[] dy = {1, -1, 0, 0}; //down up right left

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 6
        m = Integer.parseInt(st.nextToken()); // 4
        grid = new int[n][m];
        visited = new boolean[n][m][2];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = line.charAt(j) - '0';
            }
        }
        int answer = bfs();
        System.out.println(answer);
    }

    public static int bfs() {
        Queue<Position> queue = new ArrayDeque<>();
        visited[0][0][0] = true;
        queue.add(new Position(0, 0, 1, false));
        while (!queue.isEmpty()) {
            Position polled = queue.poll();
            int polledX = polled.x;
            int polledY = polled.y;
            int polledCnt = polled.cnt;
            boolean isBroken = polled.broke;
            if (polledX == n - 1 && polledY == m - 1) {
                if (min > polledCnt) min = polledCnt;
            }
            for (int i = 0; i < 4; i++) {
                int nx = polledX + dx[i];
                int ny = polledY + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (grid[nx][ny] == 0) { //이미 갈 수 있는 곳
                        if (!visited[nx][ny][isBroken ? 1 : 0]) {
                            queue.add(new Position(nx, ny, polledCnt + 1, isBroken));
                            visited[nx][ny][isBroken ? 1 : 0] = true;
                        }
                    } else if (grid[nx][ny] == 1) { //벽이 있는 곳
                        if (!isBroken) { //그 전에 부시지 않고 왔던 경우
                            if (!visited[nx][ny][1]) {
                                visited[nx][ny][1] = true;
                                queue.add(new Position(nx, ny, polledCnt + 1, true));
                            }
                        }
                    }
                }
            }
        }
        if (min == Integer.MAX_VALUE) return -1;
        else return min;
    }
}
