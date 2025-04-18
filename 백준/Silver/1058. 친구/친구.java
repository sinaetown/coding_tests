import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                if (split[j].equals("Y")) arr[i].add(j + 1);
            }
        }
//        System.out.println(Arrays.toString(arr));
        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            List<Integer> direct = arr[i];
            boolean[] visited = new boolean[n + 1];
            visited[i] = true;
            int cnt = direct.size();
            for (int d : direct) {
                visited[d] = true;
            }
            for (int d : direct) {
                cnt += find(d, visited);
            }
            if (cnt > answer) {
                answer = cnt;
            }
        }
        System.out.println(answer);
    }

    public static int find(int stop, boolean[] visited) {
        int cnt = 0;
        List<Integer> list = arr[stop];
        for (int i = 0; i < list.size(); i++) {
            if (!visited[list.get(i)]) {
                visited[list.get(i)] = true;
                cnt++;
            }
        }
        return cnt;
    }

}