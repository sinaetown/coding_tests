import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int start = -1;
        int length = l;
        boolean chk = false;
        for (int i = length; i <= 100; i++) {
            start = ((2 * n / i) + 1 - i) / 2;
            if (start < 0) continue;
            if (sum(start, i, n)) {
                length = i;
                chk = true;
                break;
            }
        }
        if (chk) {
            for (int i = 0; i < length; i++) {
                bw.write(start++ + " ");
            }
            bw.flush();
            bw.close();

        } else {
            bw.write(String.valueOf(-1));
            bw.flush();
            bw.close();
        }
    }

    public static boolean sum(int start, int i, int sum) {
        int total = 0;
        for (int a = 0; a < i; a++) {
            total += start++;
        }
        if (sum == total) return true;
        return false;
    }
}