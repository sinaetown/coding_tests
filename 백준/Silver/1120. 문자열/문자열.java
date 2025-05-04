import java.io.*;
import java.util.*;

public class Main {
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();
        bfs(a, b);
        System.out.println(min);
    }

    public static void bfs(String a, String b) {
        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.add(a);
        visited.add(a);
        while (!queue.isEmpty()) {
            String polled = queue.poll();
            if (polled.length() == b.length()) {
                int sub = cal(polled, b);
                if (sub < min) min = sub;
            } else {
                String after = polled + "*";
                String before = "*" + polled;
                if (!visited.contains(after)) {
                    visited.add(after);
                    queue.add(after);
                }
                if (!visited.contains(before)) {
                    visited.add(before);
                    queue.add(before);
                }
            }
        }
    }

    public static int cal(String a, String b) {
        int cnt = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '*') continue;
            if (a.charAt(i) != b.charAt(i)) cnt++;
        }
        return cnt;
    }
}