import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] grid = new char[m][n];
        for (int i = 0; i < m; i++) {
            grid[i] = board[m - i - 1].toCharArray(); //board의 가장 마지막 요소를 grid의 첫번째 요소로
        }

        // 무한반복
        while (true) {
            boolean chk = true;
            boolean[][] visited = new boolean[m][n];
            // 블록 체크
            for (int a = 0; a < m - 1; a++) {
                for (int b = 0; b < n - 1; b++) {
                    if (grid[a][b] == ' ') continue;
                    char c = grid[a][b];
                    if (grid[a][b + 1] == c && grid[a + 1][b] == c && grid[a + 1][b + 1] == c) {
                        visited[a][b] = true;
                        visited[a][b + 1] = true;
                        visited[a + 1][b] = true;
                        visited[a + 1][b + 1] = true;
                        chk = false;
                    }
                }
            }
            // 삭제할 블록이 더이상 없는 경우
            if (chk) break;
            // 체크된 블록 삭제 (' ' 으로 바꾸기)
            for (int a = 0; a < m; a++) {
                for (int b = 0; b < n; b++) {
                    if (visited[a][b]) {
                        grid[a][b] = ' ';
                        answer++;
                    }
                }
            }
            // 블록 내리기 (윗블록과 swap)
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == ' ') {
                        for (int k = i; k < grid.length; k++) {
                            if (grid[k][j] == ' ') {
                                continue;
                            }
                            grid[i][j] = grid[k][j];
                            grid[k][j] = ' ';
                            break;
                        }
                    }
                }
            }
        }
        return answer;
    }
}