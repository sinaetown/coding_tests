import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int k;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        System.out.println(twoPointer());
    }

    public static int twoPointer() {
        int start = 0;
        int end = 0;
        int cnt = 0;
        int max = 0;
        while (end < n) {
            if (isOdd(arr[end])) cnt++;

            while (cnt > k) {
                if (isOdd(arr[start])) cnt--;
                start++;
            }

            max = Math.max(max, end - start + 1 - cnt);
            end++;
        }
        return max;
    }

    public static boolean isOdd(int n) {
        if (n % 2 == 1) return true;
        return false;
    }
}