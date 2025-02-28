import java.io.*;
import java.util.*;

public class Main {
    static Queue<int[]> queue = new ArrayDeque<>();
    static boolean[][] visited;
    static int[][] grid;
    static List<int[]> start = new ArrayList<>();
    static int[] dx = {0, 0, 1, -1}; //R, L, D, U
    static int[] dy = {1, -1, 0, 0};
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        grid = new int[N][M];
        visited = new boolean[N][M];
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                int number = Integer.parseInt(st.nextToken());
                if (number == 1) start.add(new int[]{n, m});
                grid[n][m] = number;
            }
        }
//        for (int[] a : start) System.out.println(Arrays.toString(a));

        if (start.size() == N * M) {
            System.out.println(0);
            return;
        }
        for (int s = 0; s < start.size(); s++) {
            queue.add(new int[]{start.get(s)[0], start.get(s)[1]});
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int[] polled = queue.poll();
                build(polled[0], polled[1]);
            }
//            System.out.println(Arrays.deepToString(grid));
            cnt++;
        }
//        System.out.println(Arrays.deepToString(grid));
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                if (grid[n][m] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(cnt - 1);
    }


    public static void build(int n, int m) {
        visited[n][m] = true;
        int[] polled = new int[]{n, m};
        List<int[]> list = valid(polled);
//        System.out.println("polled!!! : " + Arrays.toString(polled));
        for (int[] l : list) {
//            System.out.println(Arrays.toString(l));
            queue.add(l);
            visited[l[0]][l[1]] = true;
            grid[l[0]][l[1]] = 1;
        }
    }

    public static List<int[]> valid(int[] polled) {
//        checks range && is not -1 && is not visited
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int nx = polled[0] + dx[i];
            int ny = polled[1] + dy[i];
            if (nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length) {
                if (grid[nx][ny] != -1 && !visited[nx][ny]) {
                    list.add(new int[]{nx, ny});
                }
            }
        }
        return list;
    }

}
