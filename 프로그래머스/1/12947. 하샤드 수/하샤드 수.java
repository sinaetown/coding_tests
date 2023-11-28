import java.lang.*;
class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        String str_x = String.valueOf(x);
        int sum = 0;
        for(int i = 0; i < str_x.length(); i++){
            sum += str_x.charAt(i) -'0';    
        }
        
        if(x%sum == 0){
            answer = true;
        }
        else{
            answer = false;
        }
        return answer;
    }
}