import java.lang.*;

class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        String oddStr = "";
        String evenStr = "";
        for(int n : num_list){
            if (n%2==1){
                oddStr += String.valueOf(n);
            }
            else{
                evenStr += String.valueOf(n);
            }
        }
        answer = Integer.parseInt(oddStr) + Integer.parseInt(evenStr);
        return answer;
    }
}