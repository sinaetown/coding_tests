import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int m;
    public static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n + 1; i++) list.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            list.get(first).add(second);
            list.get(second).add(first);
            if (first == 1) set.add(second);
            if (second == 1) set.add(first);
        }
        List<Integer> friends = list.get(1);
        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < list.get(friends.get(i)).size(); j++) {
                if (list.get(friends.get(i)).get(j) != 1) {
                    set.add(list.get(friends.get(i)).get(j));
                }
            }
        }
        System.out.println(set.size());
    }
}