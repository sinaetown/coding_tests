import java.util.*;
import java.lang.*;

class Solution {
    public int[] solution(int[] arr) {
        
        List<Integer> l = new ArrayList<>();
        for(int m : arr){
            l.add(m);
        }
        
        int i = 0;
        boolean chk= true;
        while(chk){
            if(Math.pow(2,i) > arr.length){
                for(int j = 0; j < Math.pow(2,i)-arr.length; j++){
                    l.add(0);
                }
                break;
            }
            else if (Math.pow(2,i) == arr.length){
               break;
            }
            else{
                 i++;
            }
        }
        int[] answer = new int[l.size()];
        for(int q = 0; q < l.size(); q++){
            answer[q] = l.get(q);
        }
        return answer;
    }
}