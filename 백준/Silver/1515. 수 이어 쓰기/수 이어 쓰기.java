import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        StringBuilder sb = new StringBuilder();
        int start = 1;
        int i = 0;
        while (!sb.toString().equals(n)) {
            String s = String.valueOf(start);
            for (int j = 0; j < s.length(); j++) {
                if (sb.toString().equals(n)) break;
                else if (n.charAt(i) == s.charAt(j)) {
                    sb.append(s.charAt(j));
                    i++;
                }
            }
            start++;
        }
        System.out.println(start - 1);
    }
}