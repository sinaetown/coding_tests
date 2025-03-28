import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String game = st.nextToken();
        Set<String> set = new HashSet<>();
        for (int n = 0; n < N; n++) {
            set.add(br.readLine());
        }
        int num = 0;
        if (game.equals("Y")) num = 1;
        else if (game.equals("F")) num = 2;
        else num = 3;
        System.out.println(set.size() / num);

    }
}