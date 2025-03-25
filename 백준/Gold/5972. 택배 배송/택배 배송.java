import java.io.*;
import java.util.*;

public class Main {

    public static class Way implements Comparable<Way> {
        int destination;
        int cow;

        public Way(int destination, int cow) {
            this.destination = destination;
            this.cow = cow;
        }

        @Override
        public int compareTo(Way other) {
            if (this.cow > other.cow) {
                return 1;
            } else if (this.cow == other.cow) {
                return 0;
            } else {
                return -1;
            }
        }
    }

    static int N;
    static int M;
    static List<Way>[] arr;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new List[N + 1];
        distance = new int[50001]; //시작점에서 끝지점까지 가기 위해 필요한 비용
        for (int n = 1; n <= N; n++) {
            arr[n] = new ArrayList<>();
        }
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            arr[start].add(new Way(end, cost));
            arr[end].add(new Way(start, cost));
        }

        dijkstra(1);
        System.out.println(distance[N]);
    }

    public static void dijkstra(int start) {
        //최솟값을 구해야하기 때문에 모든 요소를 MAX_VALUE로 채운다
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<Way> pq = new PriorityQueue<>();
        pq.offer(new Way(start, 0)); // 시작노드->시작노드로 가는 데 필요한 비용은 0
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Way polled = pq.poll();
            int current_idx = polled.destination;
            int current_cow = polled.cow;

            if (distance[current_idx] < current_cow) continue; //거리가 더 작다면 이미 효율적인 방안으로 처리됨
            for (int i = 0; i < arr[current_idx].size(); i++) {
                Way next = arr[current_idx].get(i);
                int next_cow = distance[current_idx] + next.cow;
                if (next_cow < distance[next.destination]) {
                    distance[next.destination] = next_cow;
                    pq.offer(new Way(next.destination, next_cow));
                }
            }

        }
    }
}
