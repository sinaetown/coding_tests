import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            if (!line.equals("ENTER")) {
                if (!set.contains(line)) {
                    set.add(line);
                }
            } else {
                cnt += set.size();
                set.clear();
            }
        }
        cnt += set.size();
        System.out.println(cnt);
    }

}