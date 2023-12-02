import java.util.*;
import java.lang.Math;

class Solution {
    public int solution(int n) {
        int answer = 0;
        String toThree = "";
        StringBuilder sb = new StringBuilder();
        
        while(n>0){
            sb.append(String.valueOf(n%3));
            n/=3;
        }
        toThree = (sb.toString());
        int len = toThree.length();
        for(int i = 0; i < toThree.length(); i++){
            answer += (toThree.charAt(i)-'0') * Math.pow(3,len-1);
            len--;
            
        }
        return answer;
    }
}