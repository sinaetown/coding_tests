import java.util.*;

class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        String s = "";
        for(int a = i; a <= j; a++){
        s = String.valueOf(a);
        for(int b = 0; b < s.length(); b++){
            if(s.charAt(b)==(char)(k+'0')){
                answer++;
            }
        }
    }
        return answer;
    }
}