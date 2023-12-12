import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < num_list.length; i+=n){
            l.add(num_list[i]);
        }
        int[] answer = new int[l.size()];
        int index = 0;
        for(int i = 0; i < l.size(); i++){
            answer[index++] = l.get(i);
        }
        return answer;
    }
}