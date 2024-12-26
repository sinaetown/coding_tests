import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        boolean[] painted = new boolean[n];
        Arrays.fill(painted, true);
        for (int i : section) {
            painted[i-1] = false;
        }
        for (int s = 0; s < painted.length; s++) {
            if (!painted[s]) {
                painted[s] = true;
                for (int q = 0; q < m; q++) {
                    if (s + q < painted.length) painted[s + q] = true;
                }
                answer++;
            }
        }
        return answer;
    }
}