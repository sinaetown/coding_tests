import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        int min = arr[0];
        List<Integer> l = new ArrayList<>();
        l.add(min);
        //find min
        for(int i = 1; i < arr.length; i++){
            l.add(arr[i]);
            if(min > arr[i]){
                min=arr[i];
            }
            else{
                continue;
            }
        }
        
        l.remove(Integer.valueOf(min));
        int[] res = new int[l.size()];
        if(l.size()==0){
            int[] empty = {-1};
            return empty;
        }
        else{
            int p = 0;
            for(int j = 0; j < l.size(); j++){
                res[p++] = l.get(j);
            }
            answer = res;
        }
        return answer;
    }
}