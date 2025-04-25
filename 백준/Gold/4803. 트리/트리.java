import java.io.*;
import java.util.*;

public class Main {
    static boolean[] check;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int ind = 1;
        while (true) {
            String line = br.readLine();
            if (line.equals("0 0")) break;
            else {
                StringTokenizer st = new StringTokenizer(line);
                int n = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());
                parent = new int[n + 1];
                check = new boolean[n + 1];
                for (int i = 1; i < n + 1; i++) {
                    parent[i] = i;
                    check[i] = true;
                }
                for (int i = 0; i < m; i++) {
                    st = new StringTokenizer(br.readLine());
                    int one = Integer.parseInt(st.nextToken());
                    int two = Integer.parseInt(st.nextToken());
                    union(one, two);
                }
                Set<Integer> set = new HashSet<>();
                for (int p = 1; p < n + 1; p++) {
                    int a = find(p);
                    if (a > 0) set.add(a);
                }
                bw.write("Case " + (ind++) + ": ");
                if (set.size() == 0) bw.write("No trees.\n");
                else if (set.size() == 1) bw.write("There is one tree.\n");

                else bw.write("A forest of " + set.size() + " trees.\n");
            }
        }
        bw.flush();
        bw.close();
    }

    public static int find(int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent[i]);
    }

    public static void union(int a, int b) {
        int parent_a = find(a);
        int parent_b = find(b);
        if (parent_a > parent_b) {
            int tmp = parent_a;
            parent_a = parent_b;
            parent_b = tmp;
        }
        if (parent_a == parent_b) parent[parent_a] = 0;
        else parent[parent_b] = parent_a;
    }

}