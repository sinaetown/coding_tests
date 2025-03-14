import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int repeat = Integer.parseInt(br.readLine());
        for (int i = 0; i < repeat; i++) {
            int num = Integer.parseInt(br.readLine());
            bw.write(fib(num)[0] + " " + fib(num)[1] + "\n");
        }
        bw.flush();
    }

    public static int[] fib(int n) {
        int[] dp = new int[n + 1];
        if (n == 0) {
            return new int[]{1, 0};
        } else if (n == 1) {
            return new int[]{0, 1};
        } else {
            dp[0] = 0;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 2] + dp[i - 1];
            }
        }
        return new int[]{dp[n - 1], dp[n]};
    }
}