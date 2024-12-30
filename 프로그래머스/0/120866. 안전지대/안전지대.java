class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    for (int a = i - 1; a < i + 2; a++) {
                        for (int b = j - 1; b < j + 2; b++) {
                            if (a >= 0 && b >= 0 && a < board.length && b < board[0].length) {
                            if (board[a][b] != 1) {
                                board[a][b] = 2;
                            }
                        }
                        }
                    }
                }
            }
        }
        for (int q = 0; q < board.length; q++) {
            for (int r = 0; r < board[q].length; r++) {
                if (board[q][r] != 0) answer++;
            }
        }
        return board.length * board[0].length - answer;
    }
}