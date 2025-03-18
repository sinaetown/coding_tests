import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, 1, -1}; // up down right left
    static int[] dy = {1, -1, 0, 0};
    static int[][] grid;
    static int N;
    static int M;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[N][M];
        visited = new boolean[N][M];
        List<Integer> list = new ArrayList<>();

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                grid[n][m] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    list.add(bfs(i, j));
                }
            }
        }
        list.sort(Comparator.reverseOrder());
        if (list.isEmpty()) {
            System.out.println(0);
            System.out.println(0);
        }
        else {
            System.out.println(list.size());
            System.out.println(list.get(0));
        }
    }

    public static int bfs(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        int cnt = 0;
        while (!queue.isEmpty()) {
            cnt++;
            int[] polled = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + polled[0];
                int ny = dy[i] + polled[1];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (!visited[nx][ny] && grid[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
        return cnt;
    }
}