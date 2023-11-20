import java.util.*;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        int len = my_string.length();
        
        char[] charArr = new char[len];
        charArr = my_string.toCharArray();
        
        for(char c : charArr){
            if(Character.isLowerCase(c)){
                 answer+=Character.toUpperCase(c);
            }
            else{
                answer+=Character.toLowerCase(c);
            }
        }
        return answer;
    }
}