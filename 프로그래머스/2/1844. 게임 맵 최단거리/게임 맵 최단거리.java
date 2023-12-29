import java.util.*;

class Solution {
    static boolean[][] visited;
    static List<List<Integer>> adjList = new ArrayList<>();

    static int[][] static_maps;
    static int m;
    static int n;

    public int solution(int[][] maps) {
        static_maps = maps;
        int answer = 0;
        m = static_maps.length;
        n = static_maps[0].length;

        visited = new boolean[m][n];
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        bfs(0, 0);
        if (visited[m - 1][n - 1]) {
            answer = static_maps[m - 1][n - 1];
        } else {
            answer = -1;
        }
        return answer;
    }

    static void bfs(int a, int b) {
        int[] dx = {-1, 1, 0, 0}; //좌우상하
        int[] dy = {0, 0, -1, 1};
        Queue<List<Integer>> queue = new LinkedList<>();
        visited[a][b] = true;
        queue.add(new ArrayList<>(Arrays.asList(a, b)));
        while (!queue.isEmpty()) {
            List<Integer> now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int x = now.get(0) + dx[d];
                int y = now.get(1) + dy[d];
                if (x >= 0 && y >= 0 && x < m && y < n) {
                    if (!visited[x][y] && static_maps[x][y] != 0) {
                        visited[x][y] = true;
                        static_maps[x][y] = static_maps[now.get(0)][now.get(1)] + 1;
                        queue.add(new ArrayList<>(Arrays.asList(x, y)));
                    }
                }
            }
        }
    }
}
