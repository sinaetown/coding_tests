import java.io.*;
import java.nio.file.WatchService;
import java.util.*;

public class Main {
    static String word;
    static HashMap<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        word = br.readLine();
        String answer = "";
        for (int i = 0; i < word.length(); i++) {
            map.put(word.charAt(i), map.getOrDefault(word.charAt(i), 0) + 1);
        }
        char odd = isNotPalindrome();
        if (odd == '-') {
            System.out.println("I'm Sorry Hansoo");
            return;
        } else {
            answer = buildPalindrome(odd);
        }
        System.out.println(answer);
    }

    public static String buildPalindrome(char odd) {
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<Character, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Character, Integer> entry = it.next();
            if (map.get(entry.getKey()) % 2 == 0) {
                map.put(entry.getKey(), map.get(entry.getKey()) / 2);
            } else map.put(entry.getKey(), (map.get(entry.getKey()) - 1) / 2);
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            if (map.containsKey(c)) {
                while (map.get(c) > 0) {
                    sb.append(c);
                    map.put(c, map.get(c) - 1);
                }
            }
        }
        if (odd != ' ') sb.append(odd);

        if (word.length() % 2 == 0) {
            int size = sb.length() - 1;
            for (int i = size; i >= 0; i--) {
                sb.append(sb.charAt(i));
            }
        } else {
            int size = sb.length() - 2;
            for (int i = size; i >= 0; i--) {
                sb.append(sb.charAt(i));
            }
        }
        return sb.toString();
    }

    public static char isNotPalindrome() {
        int odds = 0;
        char c = ' ';
        Iterator<Map.Entry<Character, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Character, Integer> next = it.next();
            if (odds >= 2) break;
            if (next.getValue() % 2 == 1) {
                c = next.getKey();
                odds++;
            }
        }
        if (odds >= 2) return '-';
        else return c;
    }
}