import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] lv = new String[N];
        int[] degree = new int[N];
        degree[0] = 0;
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            lv[n] = st.nextToken();
            degree[n] = Integer.parseInt(st.nextToken());
        }
        for (int m = 0; m < M; m++) {
            int given = Integer.parseInt(br.readLine());
            bw.write(lv[print(lv, degree, given)] + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static int print(String[] lv, int[] degree, int given) throws IOException {
        int low = 0;
        int high = degree.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (given > degree[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}