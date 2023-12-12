import java.lang.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        String lower = s.toLowerCase();
        int pcount = 0;
        int ycount = 0;
        for(int i =0; i < lower.length(); i++){
            if(lower.charAt(i)=='p'){
                pcount++;
            }
            else if(lower.charAt(i)=='y'){
                ycount++;
            }
        }
        if(ycount==pcount){
            answer = true;
        }
        else{
            answer= false;
        }
        return answer;
    }
}