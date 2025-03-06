import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> setA = new HashSet<>();
        for (int n = 0; n < N; n++) {
            setA.add(Integer.parseInt(st.nextToken()));
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int m = 0; m < M; m++) {
            if (setA.contains(Integer.parseInt(st.nextToken()))) {
                bw.write(1+"\n");
            } else bw.write(0+"\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}