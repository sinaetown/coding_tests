import java.io.*;
import java.util.*;

public class Main {
    public static class Node {
        int val;
        Node right;
        Node left;

        public Node(int val, Node right, Node left) {
            this.val = val;
            this.right = right;
            this.left = left;
        }
    }

    public static int[] arr;
    public static List<Integer>[] answer;
    static int height;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        height = Integer.parseInt(br.readLine());
        int size = (int) Math.pow(2, height) - 1;
        arr = new int[size];
        answer = new ArrayList[height];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = new ArrayList<>();
        }
        String[] split = br.readLine().split(" ");
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        subTree(0, arr.length - 1, 0);
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].size(); j++) {
                System.out.print(answer[i].get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void subTree(int left, int right, int depth) {
        if (left > right) return;
        int mid = (left + right) / 2;
        answer[depth].add(arr[mid]);
        subTree(left, mid - 1, depth + 1);
        subTree(mid + 1, right, depth + 1);
    }

}