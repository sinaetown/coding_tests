import java.lang.*;

class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String as = "";
        String bs = "";        
        
        as = String.valueOf(a);
        bs = String.valueOf(b);
        String s1 = as+bs;
        String s2 = bs+as;
        
        int sum1 = Integer.parseInt(s1);
        int sum2 = Integer.parseInt(s2);
        
        if(sum1<sum2){
            answer = sum2;
        }
        else{
            answer = sum1;
        }
      
        return answer;
    }
}