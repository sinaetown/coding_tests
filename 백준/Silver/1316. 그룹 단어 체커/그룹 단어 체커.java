import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int n = 0; n < N; n++) {
            String read = br.readLine();
            boolean flag = false;
            List<Character> list = new ArrayList<>();
            for (int i = 0; i < read.length() - 1; i++) {
                if (list.contains(read.charAt(i))) {
                    flag = true;
                    break;
                }
                if (read.charAt(i) != read.charAt(i + 1)) list.add(read.charAt(i));
            }
            if (!flag && !list.contains(read.charAt(read.length() - 1))) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}