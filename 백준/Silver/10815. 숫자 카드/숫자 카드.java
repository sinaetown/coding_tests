import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Set<Integer> set = new HashSet<>();
        for (int n = 0; n < N; n++) set.add(Integer.parseInt(st.nextToken()));
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int m = 0; m < M; m++) {
            if (set.contains(Integer.parseInt(st.nextToken()))) {
                bw.write("1");
            } else bw.write("0");
            if (m != M - 1) bw.write(" ");
        }
        bw.flush();
    }
}