import java.io.*;
import java.util.*;

public class Main {
    static int F;
    static int S;
    static int G;
    static int U;
    static int D;
    static boolean[] visited;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        visited = new boolean[1000001];
        int answer = bfs(S);
        if (answer == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(answer);
        }
    }

    public static int bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            cnt++;
            for (int i = 0; i < size; i++) {
                int polled = queue.poll();
                int goingUp = polled + U;
                int goingDown = polled - D;

                if (polled == G) {
                    return cnt - 1;
                } else {
                    if (goingUp >= 1 && goingUp <= F && !visited[polled]) {
                        queue.add(goingUp);
                    }
                    if (goingDown >= 1 && !visited[polled]) {
                        queue.add(goingDown);
                    }
                    visited[polled] = true;
                }
            }
        }
        return -1;
    }
}