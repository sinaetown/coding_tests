import java.io.*;
import java.util.*;

public class Main {
    static int[][] grid;
    static int[] dx = {-1, 0, 1, 0}; // 북동남서
    static int[] dy = {0, 1, 0, -1};
    static int answer;

    public static class Position {
        int x;
        int y;
        int dir;

        public Position(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        answer = 0;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        grid = new int[n][m];
        st = new StringTokenizer(br.readLine());
        Position current = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        for (int i = 0; i < n; i++) { // build grid
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(current.x, current.y, current.dir);
        System.out.println(answer);
    }

    public static void dfs(int x, int y, int dir) {
        if (grid[x][y] == 0) { //청소되지 않음
            grid[x][y] = 2; //청소하기
            answer++;
        }
        if (!existsDirty(x, y)) {//청소되지 않은 빈칸이 없는 경우
            if (canGoback(x, y, dir)) {
                dfs(dx[(dir + 2) % 4] + x, dy[(dir + 2) % 4] + y, dir);
            } else {
                return;
            }
        } else { //하나라도 청소가 되지 않음
            for (int i = 0; i < 4; i++) {
                dir = (dir + 3) % 4;
                int nx = dx[dir] + x;
                int ny = dy[dir] + y;
                if (nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length) {
                    if (grid[nx][ny] == 0) {
                        dfs(nx, ny, dir);
                        return;
                    }
                }
            }
        }
    }


    public static boolean canGoback(int x, int y, int dir) {
        int nx = dx[(dir + 2) % 4] + x;
        int ny = dy[(dir + 2) % 4] + y;
        if (nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length
                && grid[nx][ny] != 1) {
            return true;
        }
        return false;
    }

    public static boolean existsDirty(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length) {
                if (grid[nx][ny] == 0) { //청소되지 않음
                    return true;
                }
            }
        }
        return false; //네 칸 다 청소됨
    }
}