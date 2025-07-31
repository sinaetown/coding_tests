import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Long> list = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        long cnt = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long sub = a - b;
            list.add(sub);
        }
        list.sort(null);
        if (n % 2 == 1) System.out.println(1);
        else {
            for (long j = list.get(n / 2 - 1); j <= list.get(n / 2); j++) {
                cnt++;
            }
            System.out.println(cnt);
        }
    }
}