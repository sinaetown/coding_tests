import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int val = cal(x1, y1, r1, x2, y2, r2);
            bw.write(val + "\n");
        }
        bw.flush();
        bw.close();

    }

    public static int cal(int a, int b, int r1, int c, int d, int r2) {
        double dx = c - a;
        double dy = d - b;
        double distance = Math.sqrt(dx * dx + dy * dy);
        if (distance == 0 && r1 == r2) return -1;
        if (distance == r1 + r2 || distance == Math.abs(r1 - r2)) {
            return 1;
        }
        if (distance < r1 + r2 && distance > Math.abs(r1 - r2)) {
            return 2;
        }
        return 0;
    }
}