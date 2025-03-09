import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        long min = Long.MAX_VALUE;
        int low = 0;
        int high = N - 1;
        int left = 0, right = 0;
        while (low < high) {
            long sum = arr[low] + arr[high];
            if (min > Math.abs(sum)) {
                min = Math.abs(sum);
                left = low;
                right = high;
            }
            if (sum < 0) {
                low++;
            } else {
                high--;
            }
        }
        System.out.println(arr[left] + " " + arr[right]);
    }
}