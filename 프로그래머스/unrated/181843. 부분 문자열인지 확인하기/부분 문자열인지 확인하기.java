import java.util.regex.Pattern;

class Solution {
    public int solution(String my_string, String target) {
        int answer = 0;
        for(int i = 0; i < my_string.length()-target.length()+1; i++){
            if(my_string.substring(i, i+(target.length())).equals(target)){
                answer = 1;
            }
        }
        return answer;
    }
}