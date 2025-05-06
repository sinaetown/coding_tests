import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        List<String> group = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        for (String l : list) {
            if (group.isEmpty()) {
                group.add(l);
                continue;
            }
            boolean isPrefix = false;
            for (String g : group) {
                if (g.startsWith(l)) {
                    isPrefix = true;
                    break;
                }
            }
            if (!isPrefix) group.add(l);
        }
        System.out.println(group.size());
    }
}