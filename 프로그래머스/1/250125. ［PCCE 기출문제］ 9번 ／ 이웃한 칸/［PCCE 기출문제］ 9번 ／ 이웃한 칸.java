class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[] dh = {1, -1, 0, 0}; //up down right left
        int[] dw = {0, 0, 1, -1}; //up down right left
        for (int b = 0; b < dw.length; b++) {
            int changeH = h + dh[b];
            int changeW = w + dw[b];
            if (changeH >= 0
                    && changeW >= 0
                    && changeH <= board.length - 1
                    && changeW <= board.length - 1) {
                if (board[changeH][changeW].equals(board[h][w])) {
                    answer++;
                }
            }
        }
        return answer;
    }
}