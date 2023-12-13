import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        List<Integer> stk = new ArrayList<>();
        int i = 0;
        while(i < arr.length){
            if(stk.isEmpty()){
                    stk.add(arr[i]);
                    i++;
            }
            else{
                if(stk.get(stk.size()-1) == arr[i]){
                    stk.remove(stk.size()-1);
                    i++;
                }
                else{
                    stk.add(arr[i]);
                    i++;
                }
            }
        }
        System.out.print(stk);
        if(stk.isEmpty()){
            int[] emp = {-1};
            answer = emp;
        }
        else{
            answer = new int[stk.size()];
            for(int z = 0; z < stk.size(); z++){
                answer[z] = stk.get(z);
            }
        }
        return answer;
    }
}