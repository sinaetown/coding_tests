import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] picks = new int[n + 1];
            for (int j = 1; j < n + 1; j++) {
                picks[j] = Integer.parseInt(st.nextToken());
            }
            List<List<Integer>> list = build(n, picks);
            int sum = 0;
            boolean[] visited = new boolean[n + 1];
            for (int j = 1; j < n + 1; j++) {
                if (!visited[j]) {
                    sum += bfs(list, visited, j);
                }
            }
            bw.write(n - sum + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static List<List<Integer>> build(int n, int[] picks) {
        List<List<Integer>> list = new ArrayList<>(); //1번을 뽑은 사람 .. 2번을 뽑은 사람 ..
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 1; i < n + 1; i++) {
            list.get(picks[i]).add(i);
        }
        return list;
    }

    public static int bfs(List<List<Integer>> list, boolean[] visited, int start) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{start, 1});
        visited[start] = true;
        while (!queue.isEmpty()) {
            int[] polled = queue.poll();
            int current = polled[0];
            int cnt = polled[1];
            for (int i = 0; i < list.get(current).size(); i++) {
                List<Integer> p = list.get(current);
                if (p.get(i) == start) return cnt;
                if (!visited[p.get(i)]) {
                    queue.add(new int[]{p.get(i), cnt + 1});
                    visited[p.get(i)] = true;
                }
            }
        }
        return 0;
    }
}
