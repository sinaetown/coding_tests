import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static List<List<Integer>> list;
    static int n;
    static int e;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cases = Integer.parseInt(br.readLine());
        for (int i = 0; i < cases; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();
            visited = new boolean[n + 1];
            for (int j = 0; j < n + 1; j++) {
                list.add(new ArrayList<>());
            }
            for (int j = 1; j < e + 1; j++) {
                st = new StringTokenizer(br.readLine());
                int one = Integer.parseInt(st.nextToken());
                int two = Integer.parseInt(st.nextToken());
                list.get(one).add(two);
                list.get(two).add(one);
            }
            bw.write(bfs() - 1 + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static int bfs() {
        int sum = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        visited[1] = true;
        while (!queue.isEmpty()) {
            int polled = queue.poll();
            List<Integer> sub = list.get(polled);
            sum++;
            for (int i = 0; i < sub.size(); i++) {
                if (!visited[sub.get(i)]) {
                    visited[sub.get(i)] = true;
                    queue.offer(sub.get(i));
                }
            }
        }
        return sum;
    }
}