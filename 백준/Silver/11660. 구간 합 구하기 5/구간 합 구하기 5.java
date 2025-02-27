import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] grid = new int[n + 1][n + 1];
        int[][] dp = new int[n + 1][n + 1];
        for (int a = 1; a <= n; a++) {
            st = new StringTokenizer(br.readLine());
            for (int b = 1; b <= n; b++) {
                grid[a][b] = Integer.parseInt(st.nextToken());
            }
        }
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                dp[a][b] = dp[a - 1][b] + dp[a][b - 1] - dp[a - 1][b - 1] + grid[a][b];
            }
        }
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int sum = dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1];
            bw.write(sum + "\n");
        }
        bw.flush();
        bw.close();
    }
}