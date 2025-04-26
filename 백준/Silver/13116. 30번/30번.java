import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cases = Integer.parseInt(br.readLine());
        for (int i = 0; i < cases; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Set<Integer> set = new HashSet<>();
            set.add(a);
            while (a != 1) {
                if (a % 2 == 1) {
                    a--;
                }
                a /= 2;
                set.add(a);
            }
            while (b != 1) {
                if (set.contains(b)) break;
                if (b % 2 == 1) {
                    b--;
                }
                b /= 2;
                if (set.contains(b)) break;
            }
            bw.write(10 * b + "\n");
        }
        bw.flush();
        bw.close();
    }
}