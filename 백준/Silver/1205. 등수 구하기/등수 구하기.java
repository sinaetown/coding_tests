import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        if (N == 0) {
            System.out.println(1);
            return;
        }
        long score = Long.parseLong(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Long.parseLong(st.nextToken()));
        }
        list.add(score);
        list.sort(Comparator.reverseOrder());

        if (list.get(list.size() - 1) == score && N == P) {
            System.out.println(-1);
            return;
        }
        if (N == P && list.get(list.size() - 1) < score) {
            list.remove(list.size() - 1);
            list.add(score);
            list.sort(Comparator.reverseOrder());
        }
        System.out.println(rank(list, score));
    }

    public static int rank(List<Long> list, long target) {
        int sum = 1;
        for (Long l : list) {
            if (l == target) {
                break;
            } else {
                sum++;
            }
        }
        return sum;
    }
}
