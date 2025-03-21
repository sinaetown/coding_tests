import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static class Node {
        char value;
        Node right;
        Node left;

        public Node(char value, Node left, Node right) {
            this.value = value;
            this.right = right;
            this.left = left;
        }
    }

    static Node head = new Node('A', null, null);
    public static Node[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new Node[N + 1];
        for (int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            insertNode(head, root, left, right);
        }

        preOrder(head);
        System.out.println();
        inOrder(head);
        System.out.println();
        postOrder(head);
    }

    public static void insertNode(Node current, char root, char left, char right) {
        if (current.value == root) {
            current.left = (left == '.' ? null : new Node(left, null, null));
            current.right = (right == '.' ? null : new Node(right, null, null));
        } else {
            if (current.left != null) {
                insertNode(current.left, root, left, right);
            }
            if (current.right != null) {
                insertNode(current.right, root, left, right);
            }
        }
    }

    public static void preOrder(Node node) {
        if (node == null) return;
        System.out.print(node.value+"");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.value+"");
        inOrder(node.right);
    }

    public static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value+"");
    }
}
