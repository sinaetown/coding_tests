import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static List<List<int[]>> list = new ArrayList<>();
    public static boolean[] visited;
    public static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n + 1; i++) list.add(new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.get(start).add(new int[]{end, weight});
            list.get(end).add(new int[]{start, weight});
        }
        for (int i = 1; i < n + 1; i++) {
            visited = new boolean[n + 1];
            dfs(i, 0);
        }
        System.out.println(max);
    }

    public static void dfs(int start, int sum) {
        visited[start] = true;
        max = Math.max(sum, max);
        for (int i = 0; i < list.get(start).size(); i++) {
            int node = list.get(start).get(i)[0];
            int weight = list.get(start).get(i)[1];
            if (!visited[node]) {
                dfs(node, weight + sum);
            }
        }
    }
}
