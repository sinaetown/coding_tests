import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        int start = 666;
        while (cnt != N) {
            if (isConsecutive(String.valueOf(start))) {
                cnt++;
            }
            start++;
        }
        System.out.println(start - 1);
    }

    public static boolean isConsecutive(String s) {
        for (int i = 0; i < s.length() - 2; i++) {
            if (s.charAt(i) == '6'
                    && s.charAt(i + 1) == '6'
                    && s.charAt(i + 2) == '6') {
                return true;
            }
        }
        return false;
    }
}