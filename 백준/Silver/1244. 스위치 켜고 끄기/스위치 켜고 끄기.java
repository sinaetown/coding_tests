import java.io.*;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 1];
        for (int n = 1; n <= N; n++) arr[n] = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int switches = Integer.parseInt(st.nextToken());
            if (gender == 1) { //남학생
                for (int i = 1; i <= N; i++) {
                    if (i % switches == 0) {
                        if (arr[i] == 0) arr[i] = 1;
                        else arr[i] = 0;
                    }
                }
            } else if (gender == 2) { //여학생
                int left = switches;
                int right = switches;
                while (left - 1 >= 1 && right + 1 <= N && arr[left - 1] == arr[right + 1]) {
                    left--;
                    right++;
                }
                change(arr, left, right);
            }
        }
        for (int z = 1; z < arr.length; z++) {
            if (z % 20 == 0) bw.write(arr[z] + "\n");
            else bw.write(arr[z] + " ");
        }
        bw.flush();
        bw.close();
    }

    public static void change(int[] arr, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (arr[i] == 0) arr[i] = 1;
            else arr[i] = 0;
        }
    }
}