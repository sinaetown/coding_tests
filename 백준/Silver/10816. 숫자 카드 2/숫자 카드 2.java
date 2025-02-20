import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Map<Integer, Integer> map = new HashMap<>();
        for (int n = 0; n < N; n++) {
            int number = Integer.parseInt(st.nextToken());
            if (!map.containsKey(number)) {
                map.put(number, 1);
            } else {
                map.put(number, map.get(number) + 1);
            }
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int m = 0; m < M; m++) {
            int number = Integer.parseInt(st.nextToken());
            if (map.containsKey(number)) bw.write(String.valueOf(map.get(number)));
            else bw.write("0");
            if (m != M - 1) bw.write(" ");
        }
        bw.flush();
        bw.close();

    }
}