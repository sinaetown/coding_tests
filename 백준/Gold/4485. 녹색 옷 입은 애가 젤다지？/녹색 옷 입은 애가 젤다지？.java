import java.io.*;
import java.util.*;

public class Main {
    public static int[][] grid;
    public static int[][] dist;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int index = 1;
        while (true) {
            String line = br.readLine();
            if (line.equals("0")) break;
            int n = Integer.parseInt(line);
            grid = new int[n][n];
            dist = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
            dijkstra(n);
            bw.write("Problem " + index++ + ": " + dist[n - 1][n - 1] + "\n");
        }
        bw.flush();
    }

    public static void dijkstra(int n) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        dist[0][0] = grid[0][0];
        pq.add(new int[]{0, 0, dist[0][0]});

        while (!pq.isEmpty()) {
            int[] polled = pq.poll();
            if (polled[2] > dist[polled[0]][polled[1]]) continue;
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + polled[0];
                int ny = dy[i] + polled[1];
                if (nx >= 0 && ny >= 0 && nx < grid.length && ny < grid.length) {
                    int newRupee = grid[nx][ny] + dist[polled[0]][polled[1]];
                    if (newRupee < dist[nx][ny]) {
                        dist[nx][ny] = newRupee;
                        pq.add(new int[]{nx, ny, newRupee});
                    }
                }
            }
        }
    }
}