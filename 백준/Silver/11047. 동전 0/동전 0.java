import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int v = Integer.parseInt(br.readLine());
            if (v <= K) {
                list.add(v);
            }
        }
        list.sort(Comparator.reverseOrder());
        int coins = 0;
        int usage = 0;
        for (int i : list) {
            if (i <= K) {
                usage = K / i;
                coins += K / i;
                K -= i * usage;
            }
        }
        System.out.println(coins);
    }


}

