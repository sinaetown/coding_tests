import java.io.*;
import java.util.*;

public class Main {
    static int[] given = {1, 2, 3};
    static List<List<Integer>> total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        total = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        perm(N, K, 0, list, 0);
        StringBuilder sb = new StringBuilder();
        if (K - 1 >= total.size()) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < total.get(K - 1).size() - 1; i++) {
                sb.append(total.get(K - 1).get(i) + "+");
            }
            sb.append(total.get(K - 1).get(total.get(K - 1).size() - 1));
            System.out.println(sb);
        }
    }

    public static void perm(int N, int K, int cnt, List<Integer> list, int track) {
        if (cnt > N) return;
        else if (cnt == N) {
            total.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < given.length; i++) {
            cnt += given[i];
            list.add(given[i]);
            perm(N, K, cnt, list, track);
            cnt -= given[i];
            list.remove(list.size() - 1);
        }
    }
}