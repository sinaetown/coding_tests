import java.lang.*;

class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        int n = 0;
        int m = 0;
        for(int i = 0; i < dots.length-1; i++){
            for(int j = i+1; j < dots.length; j++){
                if(dots[i][0] == dots[j][0]){
                    n = Math.abs(dots[j][1]-dots[i][1]);
                }
                else{
                    m = Math.abs(dots[j][0]-dots[i][0]);
                }
            }
        }
        answer = n*m;
        return answer;
    }
}