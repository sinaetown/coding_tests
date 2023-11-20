import java.util.*;
class Solution {
    public int[] solution(int[] array) {
        int[] answer = new int[2];
        int idx = 0;
        int[] cpy =  new int[array.length];
        for(int a = 0; a < array.length; a++){
            cpy[idx++] = array[a];
        }
       
        Arrays.sort(array);
   
        answer[0] = array[array.length-1];
        
        for(int i = 0; i < array.length; i++){
            if(cpy[i] == answer[0]){
                answer[1]=i;
            }
        }
        return answer;
    }
}