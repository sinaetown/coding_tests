import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int target = Integer.parseInt(br.readLine());
        int low = 0;
        int high = N - 1;
        int cnt = 0;
        while (low < high) {
            if (target < arr[low] + arr[high]) {
                high--;
            } else if (target > arr[low] + arr[high]) {
                low++;
            } else {
                cnt++;
                high--;
                low++;
            }
        }
        System.out.println(cnt);
    }
}