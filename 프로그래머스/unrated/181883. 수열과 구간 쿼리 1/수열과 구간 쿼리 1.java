import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        
        List<Integer> l  = new ArrayList<>();
        for(int i : arr){
            l.add(i);
        }
        for(int i = 0; i < queries.length; i++){
            int s = queries[i][0];
            int e = queries[i][1];
            
            for(int j = s; j <= e; j++){
            l.set(j,l.get(j)+1);
        }
        }
        System.out.print(l);
        int[] answer = new int[l.size()];
        for(int i = 0; i < l.size(); i++){
            answer[i]=l.get(i);
        }
        return answer;
    }
}