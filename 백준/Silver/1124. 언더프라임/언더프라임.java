import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int res = 0;
        for (int n = a; n <= b; n++) {
            if (isUnderPrime(n)) res++;
        }
        System.out.println(res);
    }

    public static boolean isUnderPrime(int n) {
        int cnt = 0;
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                cnt++;
                n /= i;
            }
        }
        if (n > 1) cnt++; // 마지막 소인수

        for (int i = 2; i * i <= cnt; i++) {
            if (cnt % i == 0) return false;
        }
        return cnt > 1;
    }


}