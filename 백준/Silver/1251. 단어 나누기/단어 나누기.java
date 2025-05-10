import java.io.*;
import java.util.*;

public class Main {
    static String word;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        word = br.readLine();
        List<String> ans = new ArrayList<>();
        for (int i = 1; i < word.length(); i++) {
            for (int j = i + 1; j < word.length(); j++) {
                List<String> list = new ArrayList<>();
                list.add(word.substring(0, i));
                list.add(word.substring(i, j));
                list.add(word.substring(j));
                List<String> reversed = reverse(list);
                StringBuilder sb = new StringBuilder();
                for (String r : reversed) sb.append(r);
                ans.add(sb.toString());
            }
        }
        ans.sort(null);
        System.out.println(ans.get(0));
    }

    public static List<String> reverse(List<String> divided) {
        List<String> reversed = new ArrayList<>();
        for (String s : divided) {
            StringBuilder r = new StringBuilder();
            for (int i = s.length() - 1; i >= 0; i--) {
                r.append(s.charAt(i));
            }
            reversed.add(r.toString());
        }
        return reversed;
    }
}