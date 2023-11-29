import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        List<Integer> l = new ArrayList<>();
        for(int a : arr){
            if(a%divisor==0){
                l.add(a);  
            }
        }
        if(l.size()==0){
            int[] one = {-1};
            return one;
        }
        else{
            Collections.sort(l);
            int[] res = new int[l.size()];
            int j = 0;
            for(int i = 0; i < l.size(); i++){
                res[j++] = l.get(i);
            }
            answer = res;
        }
        return answer;
    }
}