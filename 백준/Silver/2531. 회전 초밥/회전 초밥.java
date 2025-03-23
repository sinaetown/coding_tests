import javax.crypto.spec.PSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        List<Integer> plates = new ArrayList<>();
        for (int n = 0; n < N; n++) {
            plates.add(Integer.parseInt(br.readLine()));
        }
        boolean[] visited = new boolean[d + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            visited = new boolean[d + 1];
            cnt++;
            visited[plates.get(i)] = true;
//            System.out.println("i : " + plates.get(i));
            for (int j = i + 1; j < i + k; j++) {
//                System.out.println("j : " + plates.get(j % N));
                if (!visited[plates.get(j % N)]) {
                    visited[plates.get(j % N)] = true;
                    cnt++;
                }
            }
            int size = 0;
            if (!visited[c]) {
                size = cnt + 1;
            } else size = cnt;
            if (size > max) max = size;
        }
        System.out.println(max);
    }
}
