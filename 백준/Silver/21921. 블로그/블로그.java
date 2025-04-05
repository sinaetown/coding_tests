import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        int left = 0;
        int right = X - 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = left; i <= right; i++) { //초기화
            sum += arr[i];
        }
        pq.add(sum);
        while (right < N - 1) {
            sum -= arr[left++];
            sum += arr[++right];
            pq.add(sum);
        }
        int max = pq.poll();
        int cnt = 1;
        if (max == 0) {
            bw.write("SAD");
            bw.flush();
            bw.close();
            return;
        }
        while (!pq.isEmpty() && pq.peek() == max) {
            cnt++;
            pq.poll();
        }
        bw.write(max + "\n");
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }
}
