import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int m;
    public static int cnt;
    public static boolean[] visited;
    public static List<List<Integer>> list = new ArrayList<>();
    public static int[] answer;
    public static List<Integer> sort = new ArrayList<>();
    public static int max = Integer.MIN_VALUE;

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
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b); //a 는 b 에게 해킹을 당할 수 있음
        }

        for (int i = 1; i < n + 1; i++) {
            visited = new boolean[n + 1];
            dfs(i);
//            bfs(i);
        }

        for (int i = 0; i < answer.length; i++) {
            max = Math.max(answer[i], max);
        }

        for (int i = 0; i < answer.length; i++) {
            if (max == answer[i]) bw.write(i + " ");
        }
        bw.flush();
        bw.close();
    }

//    public static void dfs(int start) {
//        visited[start] = true;
//        for (int i = 0; i < list.get(start).size(); i++) {
//            int next = list.get(start).get(i);
//            if (!visited[next]) {
//                answer[next]++; // 해킹을 당할 수 있는 컴퓨터의 수 올리기
//                dfs(next);
//            }
//        }
//    }

    public static void dfs(int now) {
        visited[now] = true;
        for (int next : list.get(now)) {
            if (visited[next]) continue;
            visited[next] = true;
            answer[next]++;
            dfs(next);
        }
    }
//
//    public static void bfs(int start) {
//        Queue<Integer> queue = new ArrayDeque<>();
//        visited[start] = true;
//        queue.add(start);
//
//        while (!queue.isEmpty()) {
//            int polled = queue.poll();
//            for (int i = 0; i < list.get(polled).size(); i++) {
//                if (!visited[list.get(polled).get(i)]) {
//                    visited[list.get(polled).get(i)] = true;
//                    answer[list.get(polled).get(i)]++;
//                    queue.add(list.get(polled).get(i));
//                }
//            }
//        }
//    }
}