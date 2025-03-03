import java.io.*;
import java.util.*;

public class Main {

    public static class Node {
        int num;
        int abs;

        public Node(int num, int abs) {
            this.num = num;
            this.abs = abs;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Queue<Node> q = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.abs == o2.abs) return o1.num - o2.num;
                return o1.abs - o2.abs;
            }
        });

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (q.isEmpty()) bw.write(0 + "\n");
                else bw.write(q.poll().num + "\n");
            } else {
                q.add(new Node(num, Math.abs(num)));
            }
        }
        bw.flush();
        bw.close();
    }

}