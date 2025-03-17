import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        String word = br.readLine();
        for (int n = 0; n < N - 1; n++) {
            String toComp = br.readLine();
            if (chk(word, toComp) && Math.abs(word.length() - toComp.length()) <= 1) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static boolean chk(String s1, String s2) {
        //같은 구성 == 같은 문자 같은 개수, 같은 종류 문자
        String s = s1.length() > s2.length() ? s1 : s2; //longer
        String other = s.equals(s1) ? s2 : s1; // shorter
        boolean[] visited = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < other.length(); j++) {
                if (s.charAt(i) == other.charAt(j) && !visited[j]) {
                    visited[j] = true;
                    break;
                }
            }
        }
//        System.out.println(Arrays.toString(visited));
        return chkBoolean(visited);
    }

    public static boolean chkBoolean(boolean[] boo) {
        int cnt = 0;
        for (boolean b : boo) if (b) cnt++;
        if (cnt >= boo.length - 1) return true;
        return false;
    }
}