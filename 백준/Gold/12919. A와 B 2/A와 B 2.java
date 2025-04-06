import java.io.*;
import java.util.*;

public class Main {

    static Queue<String> queue = new ArrayDeque<>();
    static Set<String> visited = new HashSet<>();
    static String S;
    static String T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        S = br.readLine();
        T = br.readLine();
        bw.write(String.valueOf(bfs(T)));
        bw.flush();
        bw.close();
    }

    public static int bfs(String str) {
        queue.add(str);
        visited.add(str);
        while (!queue.isEmpty()) {
            String polled = queue.poll();
            if (polled.length() == S.length()) {
                if (polled.equals(S)) return 1;
            }
            if(polled.isBlank()) break;
            if (polled.charAt(polled.length() - 1) == 'A') {
                if (!visited.contains(removeLast(polled))) {
                    visited.add(removeLast(polled));
                    queue.add(removeLast(polled));
                }
            }
            String reverse = reverse(polled);
            if (reverse.charAt(reverse.length() - 1) == 'B') {
                if (!visited.contains(removeLast(reverse))) {
                    visited.add(removeLast(reverse));
                    queue.add(removeLast(reverse));
                }
            }
        }
        return 0;
    }

    public static String removeLast(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length() - 1; i++) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public static String reverse(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}
