import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int k;
    public static int[] arr;
    public static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        cnt = new int[100001];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int start = 0;
        int end = 0;
        int len = 0;

        while (end < n) {
            cnt[arr[end]]++;
            while (k < cnt[arr[end]]) {
                cnt[arr[start]]--;
                start++;
            }
            len = Math.max(len, end - start + 1);
            end++;
        }
        System.out.println(len);
    }
}