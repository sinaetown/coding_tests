import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken()); // y축
        int W = Integer.parseInt(st.nextToken()); // x축
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int a = 0, b = 0;
        if (H % (N + 1) != 0) {
            a = H / (N + 1) + 1;
        } else {
            a = H / (N + 1);
        }
        if (W % (M + 1) != 0) {
            b = W / (M + 1) + 1;
        } else {
            b = W / (M + 1);
        }
        System.out.println(a * b);

    }

}