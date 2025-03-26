import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] count = new int[100001];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int low = 0;
        int high = 0;
        int answer = 0;
        while (low <= high) {
            if (high <= N - 1 && count[arr[high]] < K) {
                count[arr[high]]++;
                high++;
            } else if (count[arr[high]] == K) {
                count[arr[low]]--;
                low++;
            }
            answer = Math.max(high - low, answer);
            if (high == N) break;
        }
        System.out.println(answer);
    }
}
