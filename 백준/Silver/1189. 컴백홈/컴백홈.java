import java.io.*;
import java.util.*;

public class Main {
    static int r;
    static int c;
    static int k;
    static int ans;
    static String[][] grid;
    static boolean[][] visited;

    static int[] dx = new int[]{-1, 1, 0, 0}; //up down right left
    static int[] dy = new int[]{0, 0, 1, -1}; //up down right left

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        grid = new String[r][c];
        visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                grid[i][j] = line[j];
            }
        }
        visited[r - 1][0] = true;
        dfs(1, r - 1, 0);
        System.out.println(ans);
    }

    public static void dfs(int distance, int currentX, int currentY) {
        if (distance == k) {
            if (currentX == 0 && currentY == c - 1) ans++;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = currentX + dx[i];
            int ny = currentY + dy[i];
            if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                if (!visited[nx][ny] && grid[nx][ny].equals(".")) {
                    visited[nx][ny] = true;
                    distance++;
                    dfs(distance, nx, ny);
                    distance--;
                    visited[nx][ny] = false;
                }
            }
        }
    }
}