import java.util.*;

class Solution {
    public int[] solution(String myString) {
       
        List<Integer> l = new ArrayList<>();
        int count = 0;
        for(int i = 0; i < myString.length(); i++){
            if(myString.charAt(i) != 'x'){
               count++;
            }
            else{
                l.add(count);
                count = 0;
            }
        }
        l.add(count);
        
         int[] answer = new int[l.size()];
        int index= 0;
        for(int i = 0; i < l.size(); i++){
            answer[index++] = l.get(i);
        }
        return answer;
    }
}