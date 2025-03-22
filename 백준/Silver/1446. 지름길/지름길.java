import javax.crypto.spec.PSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static class Way {
        int start;
        int end;
        int shortcut;

        public Way(int start, int end, int shortcut) {
            this.start = start;
            this.end = end;
            this.shortcut = shortcut;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int[] dp = new int[D + 1];
        List<Way> list = new ArrayList<>();
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int shortcut = Integer.parseInt(st.nextToken());
            list.add(new Way(start, end, shortcut));
        }
        list.sort(new Comparator<Way>() {
            @Override
            public int compare(Way o1, Way o2) {
                return o1.start - o2.start;
            }
        });

        dp[0] = 0;
        for (int i = 1; i <= D; i++) {
            int min = Integer.MAX_VALUE;
            for (Way w : list) {
                if (w.end == i) {
                    int a = dp[w.start] + w.shortcut;
                    //여러 개 있을 경우
                    if (min > a) {
                        min = a;
                    }
                }
            }
            dp[i] = Math.min(1 + dp[i - 1], min);
        }
        System.out.println(dp[D]);
    }
}
