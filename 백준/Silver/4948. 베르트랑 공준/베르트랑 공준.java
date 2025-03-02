import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            bw.write((isPrime(n, 2 * n))+"\n");
        }
        bw.flush();
        bw.close();
    }

    public static int isPrime(int n, int m) {
        int answer = 0;
        int[] arr = new int[m + 1];
        boolean[] flag = new boolean[m + 1];
        for (int i = 2; i <= m; i++) {
            arr[i] = i;
        }
        for (int i = 2; i <= m; i++) {
            for (int j = i + i; j <= m; j += i) {
                flag[j] = true; // not prime
            }
        }
        for (int i = 0; i <= m; i++) {
            if (i == 1) continue;
            if (!flag[i] && i > n &&
                    i <= m) answer++;
        }
        return answer;
    }
}
