import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for (int m : moves) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][m - 1] != 0) {
                    int caught = board[i][m - 1];
                    board[i][m - 1] = 0;
                    list.add(caught);
                    break;
                }
            }
            if (list.size() >= 2) {
                if (list.get(list.size() - 1) == list.get(list.size() - 2)) {
                    list.remove(list.size() - 1);
                    list.remove(list.size() - 1);
                    answer += 2;
                }

            }
        }
        return answer;
    }
}