import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        
        List<Integer> l = new ArrayList<>();
        int s=0;
        int e=0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i]==2){
                s=i;
                break;
            }
        }
        for(int i = 0; i < arr.length; i++){
            if(arr[i]==2){
                e=i;
            }
        }
        int[] answer = new int[e-s+1];
        int index = 0;
        for(int i = s; i <= e; i++){
            answer[index++] = arr[i];
        }
        if(s==0&&e==0){
            answer[0] = -1;
        }
        return answer;
    }
}