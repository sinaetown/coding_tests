import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n][3];
        int[][] street = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                street[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = street[0][0];
        dp[0][1] = street[0][1];
        dp[0][2] = street[0][2];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    dp[i][0] = street[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
                } else if (j == 1) {
                    dp[i][1] = street[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
                } else if (j == 2) {
                    dp[i][2] = street[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (min > dp[n - 1][i]) {
                min = dp[n - 1][i];
            }
        }
        System.out.println(min);
    }
}