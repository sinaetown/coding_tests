import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[5];
        List<Integer> l = new ArrayList<>();
        for(int i : num_list){
            l.add(i);
        }
        Collections.sort(l);
        
        int j = 0;
        for(int i = 0; i < 5; i++){
              answer[j++] = l.get(i);
        }
        return answer;
    }
}