import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int count = 0;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<>();
        for (int n = 0; n < N; n++) set.add(br.readLine());
        for (int m = 0; m < M; m++) {
            if (set.contains(br.readLine())) count++;
        }
        System.out.println(count);
    }
}