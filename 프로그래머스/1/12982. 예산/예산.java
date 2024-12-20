import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < d.length; i++) {
            list.add(d[i]);
        }
        list.sort(null);
        for(int j = 0; j < list.size(); j++){
            if(budget-list.get(j) < 0) break;
            budget -= list.get(j);
            answer++;
        }
        return answer;
    }
}