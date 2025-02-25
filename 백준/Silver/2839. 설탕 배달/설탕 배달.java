import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int[] dp = new int[number + 1];
        if (number == 3) {
            System.out.println(1);
            return;
        }
        if (number == 5) {
            System.out.println(1);
            return;
        }
        if (number > 5) {
            dp[3] = 1;
            dp[5] = 1;
            for (int i = 6; i < number + 1; i++) {
                if (i % 5 == 0) dp[i] = dp[i - 5] + 1;
                else if (i % 3 == 0) dp[i] = dp[i - 3] + 1;
                else {
                    if (dp[i - 3] != 0 && dp[i - 5] != 0) {
                        dp[i] = Math.min(dp[i - 5], dp[i - 3]) + 1;
                    }
                }
            }
        }
        if (dp[number] == 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(dp[number]);
    }
}