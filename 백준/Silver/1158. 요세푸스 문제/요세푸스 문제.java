import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Deque<Integer> deque = new ArrayDeque<>();

        sb.append("<");
        for (int i = 1; i <= N; i++) deque.addLast(i);
        while (!deque.isEmpty()) {
            for (int i = 1; i < K; i++) {
                int p = deque.removeFirst();
                deque.addLast(p);
            }
            if (deque.size() == 1) sb.append(deque.removeFirst()).append(">");
            else sb.append(deque.removeFirst()).append(", ");
        }
        System.out.println(sb);
    }
}