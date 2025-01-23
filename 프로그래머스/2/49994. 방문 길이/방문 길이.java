class Solution {
    public int solution(String dirs) {
        int answer = 0;
        boolean[][][] visited = new boolean[11][11][4];
        int x = 5, y = 5, d = 0; //starting point
        int[] dx = {0, 1, 0, -1}; //down, right, up, left
        int[] dy = {-1, 0, 1, 0}; //down, right, up, left

        for (char c : dirs.toCharArray()) {
            if (c == 'U') d = 0;
            if (c == 'R') d = 1;
            if (c == 'D') d = 2;
            if (c == 'L') d = 3;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (ny < 0 || ny >= 11 || nx < 0 || nx >= 11) continue;
            if (!visited[nx][ny][d]) {
                visited[nx][ny][d] = true;
                visited[x][y][(d + 2) % 4] = true; //반대 방향도 방문 처리
                answer++;
            }
            x = nx;
            y = ny;
        }
        return answer;
    }
}