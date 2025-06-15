import java.io.*;
import java.util.*;

public class Main {
    public static List<Integer>[] tree;
    public static boolean[] removed;
    public static int cnt, delete = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n];
        removed = new boolean[n];
        int root = 0;
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (a == -1) root = i;
            else tree[a].add(i);
        }
        delete = Integer.parseInt(br.readLine());
        deleteNode(delete);
        dfs(root);
        System.out.println(cnt);
    }

    public static void dfs(int root) {
        int c = 0;
        if (removed[root]) return;
        for (int x : tree[root]) {
            if (!removed[x]) {
                dfs(x);
                c++; // 자식 노드의 개수 세기
            }
        }
        if (!removed[root] && c == 0) cnt++; // 삭제되지 않고 자식 노드가 없을 경우 (리프일 경우)
    }

    public static void deleteNode(int d) {
        removed[d] = true;
        for (int x : tree[d]) {
            if (!removed[x]) deleteNode(x);
        }
    }
}