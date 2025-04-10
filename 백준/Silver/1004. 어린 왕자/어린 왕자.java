import java.io.*;
import java.util.*;

public class Main {

    public static class Point {
        int x;
        int y;
        int r;

        public Point(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Point start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
            Point end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
            int n = Integer.parseInt(br.readLine());
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                if (inside(x, y, r, start, end)) cnt++;
                if (inside(x, y, r, end, start)) cnt++;
            }
            bw.write(cnt + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static boolean inside(int x, int y, int r, Point start, Point end) {
        return Math.pow(x - start.x, 2) + Math.pow(y - start.y, 2) < Math.pow(r, 2)
                && Math.pow(x - end.x, 2) + Math.pow(y - end.y, 2) > Math.pow(r, 2);
    }


}