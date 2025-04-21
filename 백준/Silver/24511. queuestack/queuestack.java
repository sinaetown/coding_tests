import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] type = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int t = Integer.parseInt(st.nextToken());
            type[i] = t;
        }

        st = new StringTokenizer(br.readLine());
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int t = Integer.parseInt(st.nextToken());
            if (type[i] == 0) {
                deque.add(t);
            }
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            deque.addFirst(Integer.parseInt(st.nextToken()));
            int popped = deque.removeLast();

            bw.write(popped + " ");
        }
        bw.flush();
        bw.close();
    }
}