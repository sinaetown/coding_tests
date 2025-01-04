import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        List<int[]> list = new ArrayList<>();
        for (int i = total; i > 0; i--) {
            if ((total % i) == 0) {
                list.add(new int[]{i, total / i});
            }
        }
        for (int q = 0; q < list.size(); q++) {
            if (list.get(q)[0] * 2 + (list.get(q)[1] - 2) * 2 == brown) {
                return list.get(q);
            }
        }
        return answer;
    }
}