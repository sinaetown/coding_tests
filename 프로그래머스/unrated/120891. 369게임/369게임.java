import java.lang.*;
import java.util.*;

class Solution {
    public int solution(int order) {
        int answer = 0;
        String orderString = String.valueOf(order);
        int len = orderString.length();
        char[] listC = new char[len];
        int id = 0;
        for(int i = 0; i < len; i++){
            listC[id++] = orderString.charAt(i);
        }
        
        for(int i = 0; i < len; i++){
            if(listC[i] == '3' || listC[i] == '6' || listC[i] == '9'){
                answer++;
            }
        }

        return answer;
    }
}