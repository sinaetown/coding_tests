import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int m;
    public static int max = Integer.MIN_VALUE;
    public static boolean[] visited;
    public static int[] answer;
    public static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];
        answer = new int[n + 1];
        for (int i = 0; i < n + 1; i++) list.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            list.get(first).add(second);
            list.get(second).add(first);
        }
        dfs();
//        System.out.println(Arrays.toString(answer));
        for (int i = 0; i < answer.length; i++) {
            max = Math.max(max, answer[i]);
        }
        int cnt = 0;
        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == max) {
                bw.write(i + " ");
                break;
            }
        }
        for (int i = 0; i < answer.length; i++)
            if (answer[i] == max) {
                cnt++;
            }
        bw.write(max + " ");
        bw.write(Integer.toString(cnt));
        bw.flush();
        bw.close();
    }

    public static void dfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{1, 0});
        visited[1] = true;
        while (!queue.isEmpty()) {
            int[] polled = queue.poll();
            int barn = polled[0];
            int depth = polled[1];
            answer[barn] = depth;
            List<Integer> b = list.get(barn);
            for (int i = 0; i < b.size(); i++) {
                if (!visited[b.get(i)]) {
                    visited[b.get(i)] = true;
                    queue.add(new int[]{b.get(i), depth + 1});
                }
            }
        }
    }
}