import java.util.*;

class Solution {
    public long answer;
    public long solution(int w, int h) {
        answer = 0;
        half(w,h);
        return answer*2;
    }
    
    public void half(int w, int h){
        double a = (-1)*(double)((double)h/w); //기울기
        System.out.println("a: " + a);
        
        for(int i = 1; i <= w; i++){
            int y = (int)Math.floor((double)a*i+h);
            answer+=y;
        }
    }
}