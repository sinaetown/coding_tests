import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.toList;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            int N = Integer.parseInt(br.readLine());
            comb(N, 1, 1, "1");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void comb(int N, int num, int len, String str) {
        if (len == N) {
            if (calculate(str) == 0) {
                sb.append(str + "\n");
            }
            return;
        }
        comb(N, num + 1, len + 1, str + " " + (num + 1));
        comb(N, num + 1, len + 1, str + "+" + (num + 1));
        comb(N, num + 1, len + 1, str + "-" + (num + 1));
    }

    public static int calculate(String str) {
        str = str.replaceAll(" ", "");
        Iterator<Integer> it = Arrays.stream(str.split("[+,-]"))
                .map(Integer::parseInt).collect(toList()).iterator();
        int result = it.next();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '+') {
                result += it.next();
            } else if (str.charAt(i) == '-') {
                result -= it.next();
            }
        }
        return result;
    }
}