import java.io.*;
import java.util.*;

public class Main {
    static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        memo = new int[n+1];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int tracker = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > memo[tracker]) {
                tracker++;
                memo[tracker] = arr[i];
            } else {
                int where = binarySearch(0, tracker, arr[i]);
                memo[where] = arr[i];
            }
        }
        System.out.println(tracker);
    }

    public static int binarySearch(int left, int right, int target) {
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (memo[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}