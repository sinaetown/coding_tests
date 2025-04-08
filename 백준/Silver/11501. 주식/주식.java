import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        int[] arr;
        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            long max = 0;
            long answer = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (arr[j] <= max) {
                    answer += max - arr[j];
                } else max = arr[j];
            }
            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
    }

}