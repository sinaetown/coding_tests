import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        double mid = 0, low = 0, high = Math.min(l, Math.min(w, h));
        while (low < high) {
            mid = (low + high) / 2;
            if (((long) (l / mid) * (long) (w / mid) * (long) (h / mid) < n)) {
                if (high == mid) break;
                high = mid;
            } else {
                if (low == mid) break;
                low = mid;
            }
        }
        System.out.println(low);
    }
}