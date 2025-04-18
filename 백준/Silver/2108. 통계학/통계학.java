import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] count = new int[8001];
        List<Integer> list = new ArrayList<>();
        List<Integer> comp = new ArrayList<>();
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            list.add(num + 4000);
            comp.add(num);
            count[num + 4000]++;
            if (max < count[num + 4000]) {
                max = count[num + 4000];
            }
            sum += num;
        }
        comp.sort(null);
        list.sort(null);
        int avg = Math.round((float) sum / n);
        int center = comp.get(n / 2);
        List<Integer> chk = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] == max) {
                chk.add(i);
            }
        }
        chk.sort(null);
        int freq = chk.size() > 1 ? chk.get(1) : chk.get(0);
        int range = comp.get(comp.size() - 1) - comp.get(0);
        bw.write(avg + "\n");
        bw.write(center + "\n");
        bw.write(freq - 4000 + "\n");
        bw.write(range + "\n");
        bw.flush();
        bw.close();
    }
}