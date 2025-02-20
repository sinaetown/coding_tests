import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        if (a == 0) System.out.println(0);
        else if (a == 1) System.out.println(1);
        else {
            int[] dp = new int[a + 1];
            dp[0] = 0;
            dp[1] = 1;
            for (int i = 2; i <= a; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            System.out.println(dp[a]);
        }
    }
}