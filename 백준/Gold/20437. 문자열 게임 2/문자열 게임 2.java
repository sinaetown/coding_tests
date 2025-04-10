import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String word = br.readLine();
            int k = Integer.parseInt(br.readLine());
            if (k == 1) {
                bw.write("1 1\n");
                continue;
            }
            int[] arr = new int[26];
            for (int j = 0; j < word.length(); j++) {
                arr[word.charAt(j) - 'a']++;
            }
            int min = Integer.MAX_VALUE;
            int max = -1;
            for (int j = 0; j < word.length() - 1; j++) {
                if (arr[word.charAt(j) - 'a'] < k) continue;
                int cnt = 1;
                for (int l = j + 1; l < word.length(); l++) {
                    if (word.charAt(j) == word.charAt(l)) cnt++;
                    if (cnt == k) {
                        min = Math.min(min, l - j + 1);
                        max = Math.max(max, l - j + 1);
                        break;
                    }
                }
            }
            if (min == Integer.MAX_VALUE || max == -1) bw.write("-1\n");
            else bw.write(min + " " + max + "\n");

        }
        bw.flush();
        bw.close();
    }

}