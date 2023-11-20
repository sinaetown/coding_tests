import java.util.*;

class Solution {
    public int[] solution(int n) {
        
        List<Integer> l = new ArrayList<Integer>();
        
        for(int i = 1; i <= n; i++){
            if(n%i==0){
                l.add(i);
            }
            else{
                continue;
            }
        }
        int len = l.size();
        int k = 0;
        int[] answer = new int[len];
        for(int j = 0; j < len; j++){
            answer[k++] = l.get(j);
        }
        return answer;
    }
}