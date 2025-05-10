import java.io.*;
import java.util.*;

public class Main {
    static String word;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        word = br.readLine();
        int ans = isPalindrome();
        System.out.println(ans);
    }

    public static int isPalindrome() {
        String updated = word;
        while (true) {
            boolean flag = false;
            for (int i = 0; i < updated.length(); i++) {
                if (updated.charAt(i) == '-' || updated.charAt(updated.length() - i - 1) == '-') continue;
                if (updated.charAt(i) != updated.charAt(updated.length() - i - 1)) {
                    flag = true;
                    updated = updated + "-";
                    break;
                }
            }
            if (!flag) {
                return updated.length();
            }
        }

    }


}