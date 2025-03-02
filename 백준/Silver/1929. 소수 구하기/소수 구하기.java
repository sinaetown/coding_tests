import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        isPrime(n, m);
    }

    public static void isPrime(int n, int m) {
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
            if (!flag[i] && i >= n &&
                    i <= m) System.out.println(i);
        }

    }
}
