import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] res = new int[101][101];
        int[] dx = {0, 0, 1, -1}; //up down right, left
        int[] dy = {1, -1, 0, 0}; //up down right, left
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;
        for (int r = 0; r < rectangle.length; r++) { //테두리만
            int x1 = rectangle[r][0] * 2;
            int y1 = rectangle[r][1] * 2;
            int x2 = rectangle[r][2] * 2;
            int y2 = rectangle[r][3] * 2;
            for (int a = x1; a <= x2; a++) {
                for (int b = y1; b <= y2; b++) {
                    if (a == x1 || a == x2 || b == y1 || b == y2) { //outside
                        if (res[a][b] == -1) continue;
                        res[a][b] = 1;
                    } else res[a][b] = -1; //inside
                }
            }
        }
        Deque<int[]> deque = new ArrayDeque<>();
        boolean[][] visited = new boolean[101][101];
        deque.add(new int[]{characterX, characterY, 0});
        visited[characterX][characterY] = true;

        while (!deque.isEmpty()) {
            int[] current = deque.poll();
            if (current[0] == itemX && current[1] == itemY) return current[2] / 2;
            for (int d = 0; d < 4; d++) {
                int newX = current[0] + dx[d];
                int newY = current[1] + dy[d];
                if (newX >= 0 && newX < 101 && newY >= 0 && newY < 101) {
                    if (!visited[newX][newY] && res[newX][newY]==1) {
                        visited[newX][newY] = true;
                        deque.add(new int[]{newX, newY, current[2] + 1});
                    }
                }
            }
        }
        return -1;
    }
}