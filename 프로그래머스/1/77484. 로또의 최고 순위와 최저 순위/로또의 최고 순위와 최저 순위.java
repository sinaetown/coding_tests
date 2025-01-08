import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int minMatch = 0;
        int maxMatch = 0;
        List<Integer> lottoList = new ArrayList<>();
        boolean[] flag = new boolean[win_nums.length];
        for (int i = 0; i < lottos.length; i++) lottoList.add(lottos[i]);
        for (int i = 0; i < win_nums.length; i++) {
            if (lottoList.contains(win_nums[i])) {
                minMatch++;
                flag[i] = true;
            }
        }
        for (int j = 0; j < lottoList.size(); j++) {
            if (lottoList.get(j) == 0) {
                for (int f = 0; f < flag.length; f++) {
                    if (!flag[f]) {
                        maxMatch++;
                        flag[f] = true;
                        break;
                    }
                }

            }
        }
        answer[0] = rank(minMatch + maxMatch);
        answer[1] = rank(minMatch);
        return answer;
    }
    
    public int rank(int match) {
        if (match == 6) return 1;
        if (match == 5) return 2;
        if (match == 4) return 3;
        if (match == 3) return 4;
        if (match == 2) return 5;
        else return 6;
    }
}