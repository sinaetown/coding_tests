import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        
        List<Integer> l = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < delete_list.length; j++){
                if(delete_list[j] == arr[i]){
                    l.add(arr[i]);
                }
            }
        }
        
        for(int aa : arr){
            l2.add(aa);
        }
        for(int i : l){
            l2.remove(Integer.valueOf(i));
        }
       
        int[] answer = new int[l2.size()];
        for(int i = 0; i < l2.size(); i++){
            answer[i] = l2.get(i);
        }
        return answer;
    }
}