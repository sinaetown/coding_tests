import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<String> hear = new HashSet<>();
        Set<String> total = new TreeSet<>();
        for (int n = 0; n < N; n++) hear.add(br.readLine());
        for (int m = 0; m < M; m++) {
            String person = br.readLine();
            if (hear.contains(person)) {
                total.add(person);
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = 0;
        bw.write(String.valueOf(total.size() + "\n"));
        for (String s : total) {
            if (count != total.size() - 1) {
                bw.write(s + "\n");
                count++;
            } else {
                bw.write(s);
            }
        }
        bw.flush();
        bw.close();
    }
}