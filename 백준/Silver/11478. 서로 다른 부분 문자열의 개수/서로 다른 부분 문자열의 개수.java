import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String given = br.readLine();
        int len = given.length();
        int count = 1;
        Set<String> set = new HashSet<>();
        while (count < len) {
            for (int start = 0; start < len; start++) {
                if (start + count <= len) {
                    String sub = given.substring(start, start + count);
                    set.add(sub);
                }
            }
            count++;
        }
        set.add(given);
        System.out.println(set.size());
    }
}