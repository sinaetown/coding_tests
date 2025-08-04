import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int M;
    public static int[] degree;
    public static String[] lv;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lv = new String[N];
        degree = new int[N];
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            lv[n] = st.nextToken();
            degree[n] = Integer.parseInt(st.nextToken());
        }
        for (int m = 0; m < M; m++) {
            int given = Integer.parseInt(br.readLine());
            bw.write(bs(given) + "\n");
        }
        bw.flush();
    }

    public static String bs(int target) {
        int left = 0;
        int right = N - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (degree[mid] < target) {
                left = mid + 1;
            } else right = mid - 1;
        }
        return lv[left];
    }


}