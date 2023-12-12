import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        String[] answer = new String[my_string.length()];
        int index=0;
        for(int i = 0; i < my_string.length(); i++){
            answer[index++] = my_string.substring(i);
        }
        Arrays.sort(answer);
        return answer;
    }
}