import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int INF = 1000000000;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] grid = new int[n + 1][n + 1];
//        boolean[][] visited = new boolean[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) grid[i][j] = 0;
                else grid[i][j] = INF;
            }
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            grid[one][two] = weight;
            grid[two][one] = weight;
//            visited[one][two] = visited[two][one] = true;
        }
        floyd(grid, n);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            bw.write(grid[one][two] + "\n");
        }
//        System.out.println(Arrays.deepToString(grid));
        bw.flush();
        bw.close();
    }

    public static void floyd(int[][] grid, int n) {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    grid[i][j] = Math.min(grid[i][k] + grid[k][j], grid[i][j]);
                }
            }
        }
    }
}