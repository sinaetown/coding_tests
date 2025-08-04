import java.io.*;
import java.util.*;

public class Main {
    public static int[] parent;
    public static List<List<Integer>> list = new ArrayList<>();
    public static int[] plan;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        parent = new int[n + 1];
        plan = new int[m];
        for (int i = 1; i < n + 1; i++) parent[i] = i;
        for (int i = 0; i < n + 1; i++) list.add(new ArrayList<>());
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    union(i, j);
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) plan[i] = Integer.parseInt(st.nextToken());

        int root = find(plan[0]);
        boolean canGo = true;
        for (int i = 1; i < m; i++) {
            if (find(plan[i]) != root) {
                canGo = false;
                break;
            }
        }

        System.out.println(canGo ? "YES" : "NO");
    }

    public static void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        if (parentA < parentB) {
            parent[parentB] = parentA;
        } else parent[parentA] = parentB;
    }

    public static int find(int a) {
        if (parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }
}