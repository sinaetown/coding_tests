import java.lang.*;

class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        int l = s.length();
        if((l == 4) || (l == 6)){
            for(int i = 0; i < l; i++){
                if(!(Character.isDigit(s.charAt(i)))){
                    return false;
                }
            }
        }
        else{
            return false;
        }
        return answer;
    }
}