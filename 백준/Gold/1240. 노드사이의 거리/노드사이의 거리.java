
import java.io.*;
import java.util.*;

public class Main {
    public static class Node {
        int num;
        int weight;

        public Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }

    static List<List<Node>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.get(one).add(new Node(two, weight));
            list.get(two).add(new Node(one, weight));
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            bw.write(bfs(one, two, new boolean[n + 1], n) + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static int bfs(int start, int end, boolean[] visited, int n) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(start, 0));
        visited[start] = true;
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int nowNum = now.num;
            int nowWeight = now.weight;
            if (nowNum == end) return nowWeight;
            for (int i = 0; i < list.get(nowNum).size(); i++) {
                Node next = list.get(nowNum).get(i);
                int nextNum = next.num;
                int nextWeight = next.weight;
                if (!visited[nextNum]) {
                    visited[nextNum] = true;
                    queue.add(new Node(nextNum, nowWeight + nextWeight));
                }
            }
        }
        return -1;
    }
}