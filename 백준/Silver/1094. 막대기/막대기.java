import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int x = Integer.parseInt((br.readLine()));
        int min = 64;
        int start = 64;
        if (x == start) {
            System.out.println(1);
            return;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> list = new ArrayList<>();
        list.add(64);
        while (min != 1) {
            list.sort(null);
            int sum = 0;
            int sub = 0;
            for (int i : list) {
                sum += i;
                sub += i;
            }
            if (sum == x) break;
            if (sum > x) {
                list.remove(0);
                list.add(min / 2);
                list.add(min / 2);
                sub -= min / 2;
                min /= 2;
                list.sort(null);
                if (sub >= x) list.remove(0);
            }
        }
        System.out.println(list.size());
    }
}