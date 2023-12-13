import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
       
        List<Integer> l = new ArrayList<>();
        for(int a : arr){
            l.add(a);
        }
        for(int i = 0; i < queries.length; i++){
            int temp =l.get(queries[i][0]);
            l.set(queries[i][0], l.get(queries[i][1]));
            l.set(queries[i][1], temp);
        }
         int[] answer = new int[l.size()];
        for(int i = 0 ; i < l.size(); i++){
            answer[i] = l.get(i);
        }
        return answer;
    }
}