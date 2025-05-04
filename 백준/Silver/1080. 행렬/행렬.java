import java.io.*;
import java.util.*;

public class Main {
    static int[][] a;
    static int[][] b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        a = new int[n][m];
        b = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                a[i][j] = line.charAt(j) - '0';
            }
        }
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                b[i][j] = line.charAt(j) - '0';
            }
        }
        int total = 0;
        if (isSame()) {
            System.out.println(0);
            return;
        }
        if (n < 3 || m < 3) {
            System.out.println(-1);
            return;
        }
        boolean chk = false;
        while (!isSame()) {
            for (int i = 0; i < n - 2; i++) {
                for (int j = 0; j < m - 2; j++) {
                    if (a[i][j] != b[i][j]) {
                        convert(i, j);
                        total++;
                    }
                }
            }
            if (!isSame()) {
                chk = true;
                break;
            }
        }
        if (chk) {
            System.out.println(-1);
            return;
        }
        System.out.println(total);
    }

    public static void convert(int x, int y) {
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (a[i][j] == 1) a[i][j] = 0;
                else a[i][j] = 1;
            }
        }
    }

    public static boolean isSame() {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] != b[i][j]) return false;
            }
        }
        return true;
    }
}