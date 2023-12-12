import java.util.*;

class Solution {
    public int[] solution(int[] arr, boolean[] flag) {

        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            if(flag[i]){
                for(int j = 0; j < arr[i]*2; j++){
                    l.add(arr[i]);
                }
            }
            else{
                for(int j = 0; j < arr[i]; j++){
                    l.remove(l.size()-1);
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