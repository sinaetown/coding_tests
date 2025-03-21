import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) list.add(Integer.parseInt(st.nextToken()));
        list.sort(null);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < N - 1; i++) {
            pq.add(list.get(i + 1) - list.get(i));
        }
        for (int k = 0; k < K - 1; k++) {
            pq.poll();
        }
        int answer = 0;
        while (!pq.isEmpty()) answer += pq.poll();
        System.out.println(answer);
    }

}
