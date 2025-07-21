import java.io.*;
import java.util.*;

public class Main {
    public static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if (order.equals("all")) all();
            else if (order.equals("empty")) empty();
            else if (order.equals("add")) {
                int num = Integer.parseInt(st.nextToken());
                add(num);
            } else if (order.equals("remove")) {
                int num = Integer.parseInt(st.nextToken());
                remove(num);
            } else if (order.equals("check")) {
                int num = Integer.parseInt(st.nextToken());
                if (check(num)) sb.append("1\n");
                else sb.append("0\n");
            } else if (order.equals("toggle")) {
                int num = Integer.parseInt(st.nextToken());
                toggle(num);
            }
        }
        System.out.println(sb);
    }

    public static void empty() {
        set.clear();
    }

    public static void all() {
        empty();
        for (int i = 1; i <= 20; i++) {
            set.add(i);
        }
    }

    public static void toggle(int x) {
        if (check(x)) set.remove(x);
        else set.add(x);
    }

    public static boolean check(int x) {
        if (set.contains(x)) return true;
        return false;
    }

    public static void remove(int x) {
        set.remove(x);
    }

    public static void add(int x) {
        set.add(x);
    }
}