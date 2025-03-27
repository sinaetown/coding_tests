import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            String line = br.readLine();
            if (line.equals("end")) break;
            else {
                if (first(line) && second(line) && third(line))
                    bw.write("<" + line + "> is acceptable.\n");
                else bw.write("<" + line + "> is not acceptable.\n");
            }
        }

        bw.flush();
        bw.close();
    }

    public static boolean isVowel(Character c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;
        return false;
    }

    public static boolean first(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) return true;
        }
        return false;
    }

    public static boolean second(String s) {
        for (int i = 0; i < s.length() - 2; i++) {
            if (isVowel(s.charAt(i)) && isVowel(s.charAt(i + 1)) && isVowel(s.charAt(i + 2))) {
                return false;
            } else if (!isVowel(s.charAt(i)) && !isVowel(s.charAt(i + 1)) && !isVowel(s.charAt(i + 2))) {
                return false;
            }
        }
        return true;
    }

    public static boolean third(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)
                    && (s.charAt(i) == 'e' || s.charAt(i) == 'o')) return true;
            else if(s.charAt(i) == s.charAt(i+1)) return false;
        }
        return true;
    }
}
