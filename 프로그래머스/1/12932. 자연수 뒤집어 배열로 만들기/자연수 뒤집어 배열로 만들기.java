import java.util.*;
class Solution {
    public int[] solution(long n) {

        String sn = "";
        sn = String.valueOf(n);
        int[] answer = new int[sn.length()];
        int j = 0;
        for(int i = sn.length()-1; i >= 0; i--){
            if(Character.isDigit((sn.charAt(i)))){
                answer[j++]=sn.charAt(i)-'0';
            }
        }
        return answer;
    }
}