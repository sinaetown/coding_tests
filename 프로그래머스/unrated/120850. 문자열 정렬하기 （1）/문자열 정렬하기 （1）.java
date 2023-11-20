import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        int j = 0;
        int count = 0;
        for(int i = 0; i < my_string.length(); i++){
        if(Character.isDigit(my_string.charAt(i))){
            count++;
        }
        else{
            continue;
        }
        }
        
        int[] answer = new int[count];
        for(int i = 0; i < my_string.length(); i++){
        if(Character.isDigit(my_string.charAt(i))){
            answer[j++] = my_string.charAt(i)-'0';
        }
            else{
                continue;
            }
        }
        Arrays.sort(answer);
        return answer;
    }
}