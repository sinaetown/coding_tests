import java.io.*;
import java.util.*;

public class Main {
    public static long[] arr;
    public static int n;
    public static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        int left = 0;
        int right = left;
        long sum = 0;
        int len = 100000002;
        boolean flag = false;
        while (left <= right && right < n) {
            sum += arr[right];
            while (sum >= m) {
                flag = true;
                len = Math.min(len, right - left + 1);
                sum -= arr[left];
                left++;
            }
            right++;
        }
        if (!flag) System.out.println(0);
        else System.out.println(len);
    }
}