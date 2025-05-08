import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int s;
    static int ans;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        ans = 0;
        dfs(0, 0);
        if (s == 0) ans--;
        System.out.println(ans);
    }

    public static void dfs(int idx, int total) {
        if (idx == n) {
            if (total == s) ans++;
            return;

        }
        dfs(idx + 1, total + arr[idx]);
        dfs(idx + 1, total);
    }
}