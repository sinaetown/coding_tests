import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String a = br.readLine();
        String b = br.readLine();

        int ans = Integer.MAX_VALUE;
        ans = Math.min(ans, getMinWidth(a, b));
        ans = Math.min(ans, getMinWidth(b, a));
        System.out.println(ans);
    }

    public static int getMinWidth(String left, String right) {
        int min = left.length() + right.length();
        for (int i = 0; i <= left.length(); i++) {
            boolean stop = false;
            for (int j = 0; j < right.length(); j++) {
                int leftIndex = i + j;
                if (leftIndex >= left.length()) break;
                if (left.charAt(leftIndex) == '2' && right.charAt(j) == '2') {
                    stop = true;
                    break;
                }
            }
            if (!stop) {
                int width = Math.max(left.length(), i + right.length());
                min = Math.min(min, width);
            }
        }
        return min;
    }
}


