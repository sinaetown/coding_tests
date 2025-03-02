import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            bw.write(isPrime(Integer.parseInt(br.readLine()))+"\n");
        }
        bw.flush();
        bw.close();
    }

    public static int isPrime(int n) {
        int count = 0;
        int[] arr = new int[n - 1];
        boolean[] flag = new boolean[n - 1];

        for (int i = 2; i < n - 1; i++) {
            arr[i] = i;
        }
        for (int i = 2; i < n - 1; i++) {
            for (int j = i + i; j < n - 1; j += i) {
                flag[j] = true; // not prime
            }
        }
        int start = 2;
        int end = arr.length - 1;
        while (start <= end) {
            if (!flag[start] && !flag[end]) {
                count++;
            }
            start++;
            end--;
        }
        return count;
    }
}
