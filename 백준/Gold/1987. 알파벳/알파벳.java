import java.io.*;
import java.util.*;

public class Main {
    public static char[][] grid;
    public static int n;
    public static int m;

    public static class Element {
        Set<Character> set;
        int x;
        int y;

        public Element(Set<Character> set, int x, int y) {
            this.set = set;
            this.x = x;
            this.y = y;
        }
    }

    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};
    public static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = line.charAt(j);
            }
        }
        Set<Character> set = new HashSet<>();
        set.add(grid[0][0]);
        dfs(0, 0, 1, set);
        System.out.println(max);
    }

    public static void dfs(int x, int y, int count, Set<Character> set) {
        max = Math.max(max, count);
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (!set.contains(grid[nx][ny])) {
                    set.add(grid[nx][ny]);
                    dfs(nx, ny, count + 1, set);
                    set.remove(grid[nx][ny]);
                }
            }
        }
    }
}