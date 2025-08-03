import java.io.*;
import java.util.*;

public class Main {

    public static class Point {
        int end;
        int cost;

        public Point(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }

    public static List<List<Point>> list = new ArrayList<>();
    public static int v;
    public static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        for (int i = 0; i < v + 1; i++) list.add(new ArrayList<>());
        for (int i = 0; i < e; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.get(start).add(new Point(end, cost));
            list.get(end).add(new Point(start, cost));
        }
        //prim (정점 연결)
        prim();
        System.out.println(answer);
    }

    public static void prim() {
        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.cost - o2.cost;
            }
        });
        pq.add(new Point(1, 0));
        boolean[] visited = new boolean[v + 1];
        while (!pq.isEmpty()) {
            Point polled = pq.poll();
            if (!visited[polled.end]) {
                visited[polled.end] = true;
                answer += polled.cost;
                for (int i = 0; i < list.get(polled.end).size(); i++) {
                    int nextNode = list.get(polled.end).get(i).end;
                    int nextCost = list.get(polled.end).get(i).cost;
                    if (!visited[nextNode]) {
                        pq.add(new Point(nextNode, nextCost));
                    }
                }
            }
        }
    }


}
