import java.io.*;
import java.util.*;

public class Main {
    public static int[] map;
    public static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[101];
        count = new int[101];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            map[start] = end;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            map[start] = end;
        }
        bfs();
        System.out.println(count[100]);
    }

    public static void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        count[1] = 0;
        while (!queue.isEmpty()) {
            int polled = queue.poll();
            if (polled == 100) break;
            for (int i = 1; i <= 6; i++) {
                if (polled + i > 100) continue;
                if (map[polled + i] == 0 && count[polled + i] == 0) { // 사다리도 뱀도 없고 방문하지 않음
                    count[polled + i] = count[polled] + 1;
                    queue.offer(polled+i);
                } else if (map[polled + i] != 0) { // 사다리나 뱀이 있음
                    int next = map[polled + i];
                    if (count[next] == 0) { // 방문 안 함
                        count[next] = count[polled] + 1;
                        queue.offer(next);
                    }
                }
            }

        }
    }
}