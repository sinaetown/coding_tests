import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int cnt = 0;
        int low = 0;
        int sum = 0;
        int high = 0;
        while (low < N) {
            if (high < N) {
                if (sum < M) {
                    sum += arr[high];
                    high++;
                } else if (sum > M) {
                    low++;
                    high = low;
                    sum = 0;
                } else {
                    cnt++;
                    low++;
                    high = low;
                    sum = 0;
                }
            } else {
                if (sum == M) {
                    cnt++;
                    low++;
                    high = low;
                    sum = 0;
                } else {
                    low++;
                    high = low;
                    sum = 0;
                }
            }
        }
        System.out.println(cnt);
    }
}