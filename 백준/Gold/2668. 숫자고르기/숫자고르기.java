import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static boolean[] visited;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        visited = new boolean[n + 1];
        list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 1; i <= n; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }
        list.sort(null);
        bw.write(list.size()+"\n");
        for (int i = 0; i < list.size(); i++) bw.write(list.get(i) + "\n");
        bw.flush();
        bw.close();
    }

    public static void dfs(int start, int target) {
        if (!visited[arr[start]]) {
            visited[arr[start]] = true;
            dfs(arr[start], target);
            visited[arr[start]] = false;
        }
        if (arr[start] == target) {
            list.add(target);
        }
    }
}