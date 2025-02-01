import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int camera = Integer.MIN_VALUE;
        for (int[] r : routes) {
            if (camera < r[0]) {
                camera = r[1];
                answer++;
            }
        }
        return answer;
    }
}