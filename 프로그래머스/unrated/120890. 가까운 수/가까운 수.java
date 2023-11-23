import java.lang.*;

class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        int closest = array[0];
        int subtract = Math.abs(array[0]-n);
        
        for(int i = 1; i < array.length; i++){
            if(subtract > Math.abs(array[i]-n)){
                subtract = Math.abs(array[i]-n);
                closest = array[i];
            }
            else if (subtract == Math.abs(array[i]-n)){
                if(closest > array[i]){
                    closest = array[i];
                }
                else{
                    continue;
                }
            }
        }
        answer = closest;
        return answer;
    }
}