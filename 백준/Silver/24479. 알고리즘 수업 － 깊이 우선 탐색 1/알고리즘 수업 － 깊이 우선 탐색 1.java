import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static List<Integer>[] edges;
    static int[] order;
    static int index = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        edges = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        order = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[a].add(b);
            edges[b].add(a);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(edges[i]);
        }
        dfs(R);
        for (int i = 1; i < order.length; i++) {
            System.out.println(order[i]);
        }

    }

    public static void dfs(int R) {
        order[R] = index++;
        visited[R] = true;
        List<Integer> list = edges[R];
        for (int i = 0; i < list.size(); i++) {
            if (!visited[list.get(i)]) {
                dfs(list.get(i));
            }
        }

    }
}
