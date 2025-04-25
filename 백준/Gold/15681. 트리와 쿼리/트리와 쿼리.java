import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> list = new ArrayList<>();
    static List<List<Integer>> tree = new ArrayList<>();
    static int[] parent;
    static int[] size;
    static int r;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            list.get(one).add(two);
            list.get(two).add(one);
        }
        makeTree(r, -1);
        count(r);
        for (int i = 0; i < q; i++) {
            bw.write(size[Integer.parseInt(br.readLine())] + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void makeTree(int currentNode, int p) {
        for (int node : list.get(currentNode)) {
            if (node != p) {
                tree.get(currentNode).add(node);
                parent[node] = currentNode;
                makeTree(node, currentNode);
            }
        }
    }

    public static void count(int currentNode) {
        size[currentNode] = 1;
        for (int node : tree.get(currentNode)) {
            count(node);
            size[currentNode] += size[node];
        }
    }
}