import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int R;
    static List<Integer>[] edges;
    static boolean[] visited;
    static int order = 1;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        edges = new List[N + 1];
        visited = new boolean[N + 1];
        answer = new int[N + 1];
        for (int n = 1; n <= N; n++) {
            edges[n] = new ArrayList<>();
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[a].add(b);
            edges[b].add(a);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(edges[i], Comparator.reverseOrder());
        }
        dfs(R);
        for (int i = 1; i <= N; i++) {
            System.out.println(answer[i]);
        }
    }

    public static void dfs(int start) {
        answer[start] = order++;
        visited[start] = true;
        for (int i = 0; i < edges[start].size(); i++) {
            if (!visited[edges[start].get(i)]) {
                dfs(edges[start].get(i));
            }
        }
    }
}

