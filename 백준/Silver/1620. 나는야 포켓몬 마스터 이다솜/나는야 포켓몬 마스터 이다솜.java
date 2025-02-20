import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Integer> byName = new HashMap<>();
        Map<Integer, String> byNumber = new HashMap<>();
        for (int n = 1; n < N + 1; n++) {
            String read = br.readLine();
            byName.put(read, n);
            byNumber.put(n, read);
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int m = 0; m < M; m++) {
            String read = br.readLine();
            if (Character.isDigit(read.charAt(0))) { // number
                bw.write(byNumber.get(Integer.parseInt(read))); // returns name
            } else { // name
                bw.write(String.valueOf(byName.get(read))); // returns number
            }
            if (m != M - 1) bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}