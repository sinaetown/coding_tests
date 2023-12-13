import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
       
        List <Integer> l = new ArrayList<>();
        for(int a : arr){
            l.add(a); //list set
        }
        for(int j  = 0 ; j < queries.length; j++){
            int s = queries[j][0];
            int e = queries[j][1];
            for(int i = s; i <= e; i++){
                if(i%queries[j][2]==0){
                    l.set(i,l.get(i)+1);
                }
            }
        }
 
         int[] answer = new int[l.size()];
        for(int i = 0; i < l.size(); i++){
            answer[i] = l.get(i);
        }
        return answer;
    }
}