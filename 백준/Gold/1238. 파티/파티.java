import java.io.*;
import java.util.*;


public class Main {
    public static int[][] dp;
    public static int n;
    public static int max = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        dp = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == j) dp[i][j] = 0;
                else dp[i][j] = 10000000;
            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            dp[start][end] = cost;
        }
        //플로이드-워샬 (모든 정점에서 다른 모든 정점들까지의 거리 구하기)
        floyd();
//        System.out.println(Arrays.deepToString(dp));
        for (int i = 1; i <= n; i++) {
            //파티장까지 가는 최솟값 + 파티장에서 돌아오는 최솟값
            max = Math.max(dp[i][x] + dp[x][i], max);
        }
        System.out.println(max);
    }

    public static void floyd() {
        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }
    }
}