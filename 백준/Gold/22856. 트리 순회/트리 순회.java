import java.io.*;
import java.util.*;

public class Main {
    static int[] left, right;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        left = new int[n + 1];
        right = new int[n + 1];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int parent = Integer.parseInt(st.nextToken());
            int leftChild = Integer.parseInt(st.nextToken());
            int rightChild = Integer.parseInt(st.nextToken());
            left[parent] = leftChild;
            right[parent] = rightChild;
        }
        int depth = findLastNode(1, 0);
        System.out.println(2 * (n - 1) - depth);
    }


    public static int findLastNode(int current, int depth) {
        if (right[current] != -1) return findLastNode(right[current], depth + 1);
        return depth;
    }
}