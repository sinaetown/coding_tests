import java.lang.*;

class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        answer+=my_string.substring(0,s);
        answer+=overwrite_string;
        if(s+(overwrite_string.length()) != my_string.length()){
            answer+=my_string.substring(s+overwrite_string.length());
        }
        return answer;
    }
}