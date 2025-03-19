import java.io.*;
import java.util.*;

public class Main {

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] item = new int[N + 1][2]; //Weight, Value

        for (int n = 1; n <= N; n++) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            item[n][0] = W;
            item[n][1] = V;
        }
        dp = new int[N + 1][K + 1];
        for (int k = 1; k <= K; k++) { //weight
            for (int i = 1; i <= N; i++) { //item
                dp[i][k] = dp[i - 1][k];
                if (k - item[i][0] >= 0) {
                    dp[i][k] = Math.max(dp[i - 1][k], item[i][1] + dp[i - 1][k - item[i][0]]);
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}
