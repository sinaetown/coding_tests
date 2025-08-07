import java.io.*;
import java.util.*;

public class Main {
    public static List<String> list = new ArrayList<>();
    public static int max = -1;
    public static String[] ans = new String[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int res = compare(list.get(i), list.get(j));
                if (res > max) {
                    max = res;
                    ans[0] = list.get(i);
                    ans[1] = list.get(j);
                }
            }
        }
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }

    public static int compare(String a, String b) {
        int cnt = 0;
        int shorter = Math.min(a.length(), b.length());
        for (int i = 0; i < shorter; i++) {
            if (a.charAt(i) != b.charAt(i)) break;
            else cnt++;
        }
        return cnt;
    }

}

