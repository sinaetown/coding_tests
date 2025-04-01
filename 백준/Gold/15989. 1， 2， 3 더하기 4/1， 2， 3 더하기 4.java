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
        int[][] dp = new int[K + 1][4];
        if(K==1) return 1;
        if(K==2) return 2;
        if(K==3) return 3;

        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;
        for (int i = 4; i <= K; i++) {
            dp[i][1] = dp[i - 1][1];
            dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
            dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
        }
        return dp[K][1] + dp[K][2] + dp[K][3];
    }
}