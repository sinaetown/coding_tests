import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //뭃품 수
        int k = Integer.parseInt(st.nextToken()); //버틸 수 있는 무게
        int[][] item = new int[n + 1][2];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            item[i][0] = Integer.parseInt(st.nextToken()); //weight
            item[i][1] = Integer.parseInt(st.nextToken()); //value
        }

        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) { //물품 수
            for (int j = 1; j <= k; j++) { //무게
                dp[i][j] = dp[i - 1][j];
                if (j - item[i][0] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], item[i][1] + dp[i - 1][j - item[i][0]]);
                }

            }
        }
        System.out.print(dp[n][k]);

    }
}