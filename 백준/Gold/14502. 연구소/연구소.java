import java.io.*;
import java.util.*;

public class Main {

    public static int[][] grid;
    public static int max = Integer.MIN_VALUE;
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};
    public static List<int[]> zeros = new ArrayList<>();
    public static List<List<int[]>> combinations = new ArrayList<>();
    public static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        grid = new int[n][m];
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int number = Integer.parseInt(st.nextToken());
                if (number == 0) zeros.add(new int[]{i, j});
                grid[i][j] = number;
                map[i][j] = number;
            }
        }
        comb(new ArrayList<>(), 0, new boolean[n][m]);
        build();
        System.out.println(max);
    }

    public static void build() {
        for (int i = 0; i < combinations.size(); i++) {
            List<int[]> sub = combinations.get(i);

            for (int j = 0; j < sub.size(); j++) {
                map[sub.get(j)[0]][sub.get(j)[1]] = 1;
            }
            boolean[][] visited = new boolean[map.length][map[0].length];
            for (int a = 0; a < map.length; a++) {
                for (int b = 0; b < map[0].length; b++) {
                    if (map[a][b] == 2) {
                        spread(a, b, visited);
                    }
                }
            }
            max = Math.max(calculate(map), max);
            for (int a = 0; a < map.length; a++) {
                for (int b = 0; b < map[0].length; b++) {
                    map[a][b] = grid[a][b];
                }
            }
        }
    }

    public static void comb(List<int[]> sub, int index, boolean[][] visited) {
        if (sub.size() == 3) {
            combinations.add(new ArrayList<>(sub));
            return;
        }
        for (int i = index; i < zeros.size(); i++) {
            if (!visited[zeros.get(i)[0]][zeros.get(i)[1]]) {
                sub.add(zeros.get(i));
                visited[zeros.get(i)[0]][zeros.get(i)[1]] = true;
                comb(sub, i, visited);
                visited[zeros.get(i)[0]][zeros.get(i)[1]] = false;
                sub.remove(sub.size() - 1);
            }
        }
    }

    public static void spread(int x, int y, boolean[][] visited) {
        Queue<int[]> queue = new ArrayDeque<>();
        visited[x][y] = true;
        queue.add(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] polled = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = polled[0] + dx[i];
                int ny = polled[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length) {
                    if (!visited[nx][ny] && map[nx][ny] == 0) {
                        queue.add(new int[]{nx, ny});
                        map[nx][ny] = 2;
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }

    public static int calculate(int[][] map) {
        int cnt = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }

}
