import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length-5];
        List<Integer> l  = new ArrayList<>();
       for(int i = 0; i < num_list.length; i++){
           l.add(num_list[i]);
       }
        Collections.sort(l);
        int j =0;
        for(int i = 5; i < l.size(); i++){
            answer[j++] = l.get(i);
        }
        return answer;
    }
}