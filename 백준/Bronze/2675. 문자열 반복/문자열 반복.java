import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> l = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int repeat = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            String temp = "";
            int index = 0;
            for (int j = 0; j < s.length(); j++) {
                for (int k = 0; k < repeat; k++) {
                    temp += s.charAt(j);
                }

            }
            l.add(temp);
        }
        for (String ll : l) {
            System.out.println(ll);
        }
    }
}
