import java.util.*;
class Solution {
    static int answer = 0;
    static int count = 0;
    public int solution(int balls, int share) {
       
        
         ballsRecur(balls, share, 0);
        
        return answer;
    }
    
     static void ballsRecur(int balls, int share, int start) {
        if (count == share) {
            answer++;
            return;
        }
        for (int i = start; i < balls; i++) {
            count += 1;
            ballsRecur(balls, share, i + 1);
            count -= 1;
        }
    }
}