import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int K = Integer.parseInt(br.readLine());
            bw.write(find(K) + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static long find(int K) {
        long[] dp = new long[K + 1];
        if (K == 1) return 1;
        if (K == 2) return 2;
        if (K == 3) return 4;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= K; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000009;
        }
        return dp[K];

    }
}