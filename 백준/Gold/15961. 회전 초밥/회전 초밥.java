import javax.crypto.spec.PSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //접시 수
        int d = Integer.parseInt(st.nextToken()); // 총 초밥 가짓수
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        int[] selected = new int[d + 1];
        int[] sushi = new int[N];
        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }
        selected[c] = 1; //쿠폰은 먹은 걸로 가정
        int cnt = 1;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < k; i++) { // 초기 k 접시 initialize
            if (selected[sushi[i]] == 0) {
                cnt++;
            }
            selected[sushi[i]]++;
        }
        max = cnt;
        for (int i = 0; i < N - 1; i++) {
            selected[sushi[i]]--;
            if (selected[sushi[i]] == 0) cnt--;
            selected[sushi[(i + k) % N]]++;
            if (selected[sushi[(i + k) % N]] == 1) cnt++;
            if (max < cnt) max = cnt;
        }

        System.out.println(max);
    }
}
