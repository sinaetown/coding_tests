import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];
        int ind = 0;
        for (long i = left; i <= right; i++) {
            int max = Math.max((int) (i / n), (int) (i % n));
            answer[ind++] = max + 1;
        }
        return answer;
    }
}