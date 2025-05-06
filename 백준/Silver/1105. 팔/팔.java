import javax.swing.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String l = st.nextToken();
        String r = st.nextToken();
        int cnt = 0;
        if (l.length() < r.length()) l = convert(l, r.length() - l.length());
        else if (l.length() > r.length()) r = convert(r, l.length() - r.length());
        for (int i = 0; i < r.length(); i++) {
            if (r.charAt(i) != l.charAt(i)) {
                break;
            } else if (r.charAt(i) == '8' && '8' == l.charAt(i)) cnt++;

        }
        System.out.println(cnt);
    }

    public static String convert(String a, int n) {
        for (int i = 0; i < n; i++) {
            a = '0' + a;
        }
        return a;
    }

}