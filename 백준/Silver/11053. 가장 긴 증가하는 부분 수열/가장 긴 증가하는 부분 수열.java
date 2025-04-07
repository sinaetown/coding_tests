import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] memo = new int[n];
        Arrays.fill(memo, 1);
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) memo[i] = Math.max(memo[j] + 1, memo[i]);
            }
        }
        int max = -1;
        for(int i = 0; i < n; i++){
            if(max<memo[i]) max = memo[i];
        }
        System.out.println(max);
    }
}