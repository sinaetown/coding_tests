import java.io.*;
import java.util.*;

public class Main {
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int min = Integer.MAX_VALUE;

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int start = 0;
        int end = 1;
        while (start <= end && end < n) {
            int diff = arr[end] - arr[start];
            if (m <= diff) {
                min = Math.min(diff, min);
                start++;
                end = start + 1;
            } else end++;
        }
        System.out.println(min);
    }
}