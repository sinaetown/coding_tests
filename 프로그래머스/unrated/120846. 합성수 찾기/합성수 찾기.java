import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        List<Integer> l = new ArrayList<Integer>();
        for(int i = 1; i <= n; i++){
           for(int j = 1; j <= i; j++){ 
               if(i%j==0){
               l.add(i);
            }
           }
            if(l.size()>=3){
                answer++;
            }
            l.clear();
        }
        
        return answer;
    }
}