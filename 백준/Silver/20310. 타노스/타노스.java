import java.io.*;
import java.util.*;

public class Main {
    public static boolean[] remove;
    public static String S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        //0은 뒤에서부터 제거
        //1은 앞에서부터 제거

        S = br.readLine();
        int[] counts = count(S);
        remove = new boolean[S.length()];

        remove('0', counts[0]);
        remove('1', counts[1]);
        for (int i = 0; i < remove.length; i++) {
            if (!remove[i]) sb.append(S.charAt(i));
        }
        System.out.println(sb);
    }

    public static void remove(int target, int counts) {
        int cnt = 0;
        if (target == '1') {
            for (int i = 0; i < S.length(); i++) {
                if (cnt == counts) break;
                if (S.charAt(i) == target) {
                    cnt++;
                    remove[i] = true;
                }
            }
        } else if (target == '0') {
            for (int i = S.length() - 1; i >= 0; i--) {
                if (cnt == counts) break;
                if (S.charAt(i) == target) {
                    cnt++;
                    remove[i] = true;
                }
            }
        }
    }

    public static int[] count(String s) {
        int zero = 0;
        int one = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') zero++;
            if (s.charAt(i) == '1') one++;
        }
        return new int[]{zero / 2, one / 2};
    }

}