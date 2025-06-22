import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int m;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int start = 0;
        int end = 0;
        int ans = 0;
        int sum = 0;
        while (end < n) {
            sum += arr[end];

            while (sum > m) {
                sum -= arr[start];
                start++;
            }
            if (sum == m) ans++;
            end++;
        }
        System.out.println(ans);

    }
}