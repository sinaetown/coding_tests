import java.io.*;
import java.util.*;

public class Main {
    static public class Node {
        int parent;
        int right;
        int left;

        public Node(int parent, int right, int left) {
            this.parent = parent;
            this.right = right;
            this.left = left;
        }
    }

    static Node[] tree;
    static int cnt = 0;
    static boolean[] visited;
    static int lastNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new Node[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) tree[i] = new Node(-1, -1, -1);
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int parent = Integer.parseInt(st.nextToken());
            int leftChild = Integer.parseInt(st.nextToken());
            int rightChild = Integer.parseInt(st.nextToken());
            tree[parent].left = leftChild;
            tree[parent].right = rightChild;

            if (leftChild != -1) tree[leftChild].parent = parent;
            if (rightChild != -1) tree[rightChild].parent = parent;


        }
        findLastNode(1);
        dfs(1);
        System.out.println(cnt);
    }


    public static void dfs(int current) {
        visited[current] = true;
        if (tree[current].left != -1 && !visited[tree[current].left]) {
            cnt++;
            dfs(tree[current].left);
        } else if (tree[current].right != -1 && !visited[tree[current].right]) {
            cnt++;
            dfs(tree[current].right);
        } else if (lastNode != current) {
            cnt++;
            dfs(tree[current].parent);
        }
    }


    public static void findLastNode(int current) {
        if (current == -1) return;
        findLastNode(tree[current].left);
        lastNode = current;
        findLastNode(tree[current].right);
    }
}