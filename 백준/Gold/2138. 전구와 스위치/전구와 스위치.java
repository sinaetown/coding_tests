import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] bulbs = br.readLine().toCharArray();
        char[] pressFirst = Arrays.copyOf(bulbs, bulbs.length);

        pressFirst[0] = bulbs[0] == '1' ? '0' : '1';
        pressFirst[1] = bulbs[1] == '1' ? '0' : '1';

        char[] target = br.readLine().toCharArray();

        int cnt = 0;
        int pressFirstCnt = 1;

        for (int i = 1; i < bulbs.length; i++) {
            //누르지 않은 경우
            if (bulbs[i - 1] != target[i - 1]) {
                bulbs[i - 1] = bulbs[i - 1] == '1' ? '0' : '1';
                bulbs[i] = bulbs[i] == '1' ? '0' : '1';
                if (i + 1 < bulbs.length) {
                    bulbs[i + 1] = bulbs[i + 1] == '1' ? '0' : '1';
                }
                cnt++;
            }
            //누른 경우
            if (pressFirst[i - 1] != target[i - 1]) {
                pressFirst[i - 1] = pressFirst[i - 1] == '1' ? '0' : '1';
                pressFirst[i] = pressFirst[i] == '1' ? '0' : '1';
                if (i + 1 < pressFirst.length) {
                    pressFirst[i + 1] = pressFirst[i + 1] == '1' ? '0' : '1';
                }
                pressFirstCnt++;
            }
        }
        if (isSame(bulbs, target)) System.out.println(cnt);
        else if (isSame(pressFirst, target)) System.out.println(pressFirstCnt);
        else System.out.println(-1);
    }

    public static boolean isSame(char[] a, char[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}