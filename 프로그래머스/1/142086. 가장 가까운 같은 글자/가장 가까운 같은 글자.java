import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        char[] s_arr = s.toCharArray();
        int tracker = 1;
        int k = 1;
        answer[0] = -1;
       for(int i = 1; i < s_arr.length; i++){
           for(int j = i-1; j >= 0; j--){
               if(s_arr[i] == s_arr[j]){
                   answer[k++] = i-j;
                   break;
               }
               else if (s_arr[i] != s_arr[j]){
                   if(j==0){
                        answer[k++] = -1;
                   }
                   else{
                        continue;
                   }
               }
           }
       }
        
        return answer;
    }
}