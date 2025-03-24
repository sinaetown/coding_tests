import javax.crypto.spec.PSource;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] belt = new int[N * 2 + 1];
        boolean[] robot = new boolean[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int n = 1; n <= N * 2; n++) {
            belt[n] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;

        while (true) {
            // 1단계 (벨트 회전)
            answer++;
            int tmp = belt[N * 2];
            for (int i = N * 2; i > 1; i--) {
                belt[i] = belt[i - 1];
            }
            belt[1] = tmp;

            for (int i = N; i > 1; i--) {
                robot[i] = robot[i - 1];
            }
            robot[1] = false;
            robot[N] = false;

            //2단계 (로봇 이동)
            for (int i = N; i > 0; i--) {
                if (belt[i] >= 1 && !robot[i] && robot[i - 1]) { //내구도가 1이상, 로봇이 없음
                    belt[i]--;
                    robot[i] = true;
                    robot[i - 1] = false;
                }
            }

            //3단계 (로봇 올리기)
            if (belt[1] != 0 && !robot[1]) {
                belt[1]--;
                robot[1] = true;
            }

            //4단계 (내구도 체크)
            int cnt = 0;
            for (int i = 1; i <= N * 2; i++) {
                if (belt[i] == 0) cnt++;
                if (cnt >= K) {
                    System.out.println(answer);
                    return;
                }
            }
        }

    }
}
