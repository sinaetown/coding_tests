import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            list.add(num);
            sum += num;
        }
        list.sort(null);
        int total = Integer.parseInt(br.readLine());
        if (sum <= total) {
            System.out.println(list.get(list.size() - 1));
            return;
        }
        int start = (int) (total / N);
        while (start <= list.get(list.size() - 1)) {
            int sub = 0;
            for (int i = 0; i < N; i++) {
                if (list.get(i) <= start) {
                    sub += list.get(i);
                } else {
                    sub += start;
                }
            }
            if (sub > total) {
                break;
            }
            start++;
        }
        System.out.println(start - 1);

    }
}