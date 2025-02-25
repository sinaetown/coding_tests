import java.io.*;
import java.util.*;

public class Main {
    static boolean[] chk;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        if (n == 1) System.out.println();
        chk = new boolean[n + 1];
        arr = new int[n + 1];
        int z = 2;
        for (int a = 2; a <= n; a++) {
            arr[a] = a;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i + i; j <= n; j += i) {
                chk[j] = true;
            }
        }
        while (n != 1) {
            if (!chk[z]) {
                if (n % z == 0) {
                    bw.write(z+ "\n");
                    n /= z;
                } else z++;
            } else z++;
        }
        bw.flush();
        bw.close();
    }
}