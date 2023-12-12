import java.util.*;

class Solution {
    public int[] solution(int n, int k) {
        
        List<Integer> l = new ArrayList<>();
        int a = k;
        int increment = 1;
        int count = 0;
        while(count != (int)n/k){
            a = increment*k;
            l.add(a);
            increment++;
            count++;
        }
        
        int[] answer = new int[l.size()];
        for(int i = 0; i < l.size(); i++){
            answer[i] = l.get(i);
        }
        return answer;
    }
}