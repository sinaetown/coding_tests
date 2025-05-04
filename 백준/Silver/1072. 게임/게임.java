import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double x = Integer.parseInt(st.nextToken());
        double y = Integer.parseInt(st.nextToken());
        int p = (int) (y * 100 / x);
        int cnt = -1;
        int left = 0;
        int right = (int) 1e9;
        while (left <= right) {
            int mid = (left + right) / 2;
            if ((int) (((y + mid) * 100) / (x + mid)) != p) {
                cnt = mid;
                right = mid - 1;
            } else left = mid + 1;
        }
        System.out.println(cnt);
    }
}