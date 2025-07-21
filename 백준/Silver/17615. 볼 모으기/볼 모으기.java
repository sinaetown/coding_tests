import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String balls = br.readLine();
        int answer = Integer.MAX_VALUE;
        boolean start = false;
        int cnt = 0;
        //왼쪽으로 빨간공
        for (int i = 0; i < n; i++) {
            if (start && balls.charAt(i) == 'R') {
                cnt++;
            }
            if (balls.charAt(i) == 'B') start = true;
        }
        answer = Math.min(answer, cnt);
        cnt = 0;
        start = false;
        //왼쪽으로 파란공
        for (int i = 0; i < n; i++) {
            if (start && balls.charAt(i) == 'B') {
                cnt++;
            }
            if (balls.charAt(i) == 'R') start = true;
        }
        answer = Math.min(answer, cnt);

        cnt = 0;
        start = false;
        //오른쪽으로 빨간
        for (int i = n - 1; i >= 0; i--) {
            if (start && balls.charAt(i) == 'R') {
                cnt++;
            }
            if (balls.charAt(i) == 'B') start = true;
        }
        answer = Math.min(answer, cnt);

        cnt = 0;
        start = false;
        //오른쪽으로 파랑
        for (int i = n - 1; i >= 0; i--) {
            if (start && balls.charAt(i) == 'B') {
                cnt++;
            }
            if (balls.charAt(i) == 'R') start = true;
        }
        answer = Math.min(answer, cnt);

        System.out.println(answer);
    }
}