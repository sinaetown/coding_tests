import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int cnt = 1;
        if (N == 1) {
            bw.write(Integer.toString(1));
            bw.flush();
            bw.close();
        } else {
            N--;
            while (N > 0) {
                N -= 6 * cnt;
                if (N <= 0) break;
                cnt++;
            }
            bw.write(Integer.toString(cnt + 1));
            bw.flush();
            bw.close();
        }
    }
}