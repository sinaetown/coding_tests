import java.io.*;
import java.util.*;

public class Main {

    static int M;
    static int min = Integer.MAX_VALUE;
    static int tracker = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < calComb(N); i++) {
            comb(0, i, 0, new boolean[N], list, new ArrayList<>());
        }
        System.out.println(tracker);
    }

    public static void comb(int count, int start, int sum, boolean[] visited, List<Integer> list, List<Integer> sub) {
        if (sub.size() == 3) {
            if (sum <= M && Math.abs(sum - M) < min) {
                min = Math.abs(sum - M);
                tracker = sum;
            }
            return;
        }
        for (int i = start; i < list.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                sum += list.get(i);
                sub.add(list.get(i));
                comb(count + 1, start + 1, sum, visited, list, sub);
                visited[i] = false;
                sum -= sub.get(sub.size() - 1);
                sub.remove(sub.size() - 1);
            }
        }
    }

    public static int calComb(int n) {
        return (n * (n - 1) * (n - 2)) / 6;
    }
}