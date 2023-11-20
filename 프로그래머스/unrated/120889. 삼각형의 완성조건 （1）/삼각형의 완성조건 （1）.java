import java.util.*;

class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        Arrays.sort(sides);
        if (sides[sides.length-1] < sides[0]+sides[1]){
           answer = 1;
        }
        else{
            answer =2;
        }
        return answer;
    }
}