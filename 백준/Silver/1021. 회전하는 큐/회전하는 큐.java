import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }
        int m = Integer.parseInt(st.nextToken());
        int[] order = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        for (int i = 0; i < order.length; i++) {
            int index = q.indexOf(order[i]);
            int middle = q.size() / 2;
            if (index <= middle) { // 2번
                while (q.get(0) != order[i]) {
                    int polled = q.pollFirst();
                    q.addLast(polled);
                    answer++;
                }
            } else {
                while (q.get(0) != order[i]) {
                    int polled = q.pollLast();
                    q.addFirst(polled);
                    answer++;

                }
            }
            if (order[i] == q.peekFirst()) q.poll();
        }
        System.out.println(answer);

    }
}