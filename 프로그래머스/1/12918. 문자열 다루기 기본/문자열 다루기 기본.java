import java.util.*;
import java.util.regex.Pattern;

class Solution {
    public boolean solution(String s) {
        boolean answer = true;
         if(Pattern.matches("([0-9]{4})|([0-9]{6})", s)){
          answer = true;
      }
      else{
          answer = false;
      }
        // int l = s.length();
        // if((l == 4) || (l == 6)){
        //     for(int i = 0; i < l; i++){
        //         if(!(Character.isDigit(s.charAt(i)))){
        //             return false;
        //         }
        //     }
        // }
        // else{
        //     return false;
        // }
        return answer;
    }
}