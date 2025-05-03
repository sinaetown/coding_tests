import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> list = new ArrayList<>();
        int l = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < l; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        list.sort(null);
        int n = Integer.parseInt(br.readLine());
        if (list.contains(n)) {
            System.out.println(0);
        } else if (list.get(0) > n) {
            int total = 0;
            int min = 1, max = list.get(0);
            int track = min;
            while (track < n) {
                total += (max - 1) - n + 1;
                track++;
            }
            total += max - 1 - n;
            System.out.println(total);
        } else {
            int min = 0, max = 0;
            for (int j = 0; j < list.size() - 1; j++) {
                if (list.get(j + 1) > n && list.get(j) < n) {
                    min = list.get(j);
                    max = list.get(j + 1);
                }
            }
//            System.out.println(list);
//            System.out.println("min: " + min + ", max: " + max);
            int total = 0;
            int track = min + 1;
            while (track < n) {
                total += (max - 1) - n + 1;
                track++;
            }
            total += max - 1 - n;
            System.out.println(total);
        }
    }
}