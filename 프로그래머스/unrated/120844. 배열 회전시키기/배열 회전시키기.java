import java.util.*;

class Solution {
    public int[] solution(int[] numbers, String direction) {
        int[] answer = new int[numbers.length];
        List<Integer> l = new ArrayList<Integer>();
        int r_temp = 0;
        int l_temp = 0;
        if(direction.equals("right")){
            r_temp = numbers[numbers.length-1];
            l.add(r_temp);
            for(int i = 0; i < numbers.length-1; i++){
                l.add(numbers[i]);
            }
        }
        else if (direction.equals("left")){
            l_temp = numbers[0];
             for(int i = 1; i < numbers.length; i++){
                l.add(numbers[i]);
            }
            l.add(l_temp);
        }
        
        int ind = 0;
        for(int j = 0; j < l.size(); j++){
            answer[ind++] = l.get(j);
        }
        return answer;
    }
}