import java.util.*;
import java.lang.*;

class Solution {
    public int solution(int num, int k) {
        int answer = 0;
        String numStr = String.valueOf(num);
        List<Integer> c = new ArrayList<Integer>();
        
        for(int i = 0; i < numStr.length(); i++){
            c.add((numStr.charAt(i))-'0');
        }
        
        // System.out.print('2'-'0');
        // System.out.print(c.indexOf(k)+1);
        answer=c.indexOf(k)+1;
        if(answer==0){
            answer = -1;
            return answer;
        }
        return answer;
    }
}