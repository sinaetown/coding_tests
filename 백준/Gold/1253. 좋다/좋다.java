import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            while (true) {
                if (i == left) left++;
                else if (i == right) right--;
                if (left >= right) break;
                if (arr[left] + arr[right] < arr[i]) left++;
                else if (arr[left] + arr[right] > arr[i]) right--;
                else {
                    ans++;
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}