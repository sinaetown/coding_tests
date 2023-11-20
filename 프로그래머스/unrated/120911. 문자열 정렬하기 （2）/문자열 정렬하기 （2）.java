import java.lang.*;
import java.util.*;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        String lower = "";
        lower = my_string.toLowerCase();
        char[] clist = new char[my_string.length()];
        clist = lower.toCharArray();
        Arrays.sort(clist);
        
        for(int i = 0; i < clist.length; i++){
           answer+=clist[i];
        }
        return answer;
    }
}