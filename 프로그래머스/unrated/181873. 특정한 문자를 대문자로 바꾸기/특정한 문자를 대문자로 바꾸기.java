import java.util.*;
import java.lang.*;

class Solution {
    public String solution(String my_string, String alp) {
        String answer = "";
        char toCapital = ' ';
        for(int i  = 0; i < my_string.length(); i++){
            if (my_string.charAt(i)==alp.charAt(0)){
                toCapital = Character.toUpperCase(my_string.charAt(i));
                answer+=toCapital;
            }
            else{
                answer+=my_string.charAt(i);
            }
        }
        return answer;
    }
}