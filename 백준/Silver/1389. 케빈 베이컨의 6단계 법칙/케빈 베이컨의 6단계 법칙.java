import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer = Integer.MAX_VALUE;
        int person = 101;
        int[][] grid = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == j) continue;
                grid[i][j] = 1000000;
            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            grid[a][b] = 1;
            grid[b][a] = 1;
        }
        floyd(grid, n);
        for (int i = n; i > 0; i--) {
            int sum = 0;
            for (int j = 0; j < n + 1; j++) {
                sum += grid[i][j];
            }
            if (sum <= answer) {
                answer = sum;
                if (i < person) person = i;
            }
        }
        System.out.println(person);
    }

    public static void floyd(int[][] grid, int n) {
        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    grid[i][j] = Math.min(grid[i][k] + grid[k][j], grid[i][j]);
                }
            }
        }
    }
}