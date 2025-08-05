import java.io.*;
import java.util.*;

public class Main {
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int left = 0;
        int right = 0;
        long ans = 0;
        Set<Integer> set = new HashSet<>();
        while (right < N) {
            if (!set.contains(arr[right])) {
                set.add(arr[right]);
                ans += (right - left + 1);
                right++;
            } else {
                set.remove(arr[left]);
                left++;
            }
        }
        System.out.println(ans);
    }


}
