import java.util.*;
class Solution {
    public int[] solution(int[] numlist, int n) {
        List<Integer> num = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int min = 0;
        int min_ind = 0;
        
        for (int i : numlist) {
            num.add(i);
            minus.add(Math.abs(i - n));
        }
        while (!num.isEmpty()) {
            min = minus.get(0);
            min_ind = 0;
            for (int i = 1; i < minus.size(); i++) {
                if (min > minus.get(i)) {
                    min = minus.get(i);
                    min_ind = i;
                } else if (min == minus.get(i)) {
                    if (num.get(min_ind) > num.get(i)) {
                        min = minus.get(min_ind);
                    } else if (num.get(min_ind) < num.get(i)) {
                        min = minus.get(i);
                        min_ind = i;
                    }
                }
            }
            res.add(num.get(min_ind));
            num.remove(min_ind);
            minus.remove(min_ind);
        }
        int ind = 0;
        int[] answer = new int[res.size()];
        for(int i:res){
            answer[ind++] = i;
        }
        return answer;
    }
}