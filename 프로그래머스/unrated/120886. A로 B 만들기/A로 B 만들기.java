import java.util.*;

class Solution {
    public int solution(String before, String after) {
        int answer = 0;
        int bb = 0;
        int aa = 0;
        char[] bc = new char[before.length()];
        char[] ac = new char[after.length()];
        
        for(int i = 0; i < before.length(); i++){
            bc[bb++] = before.charAt(i);
        }
        
        for(int i = 0; i < after.length(); i++){
            ac[aa++] = after.charAt(i);
        }
        
        Arrays.sort(bc);
        Arrays.sort(ac);
        
        String bs = "";
        String as = "";
        for(int i = 0; i < bc.length; i++){
            bs+=bc[i];
        }
        for(int i = 0; i < ac.length; i++){
            as+=ac[i];
        }
        
        if(bs.equals(as)){
            answer = 1;
        }
        else{
            answer = 0;
        }
        return answer;
    }
}