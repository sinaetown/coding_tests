class Solution {
    public String solution(int n) {
        String answer = "";
        if(n%2==0){
            for(int i = 1; i <= n/2; i++){
            answer+="수";
            answer+="박";
        }
        }
        else{
            for(int i = 0; i < n; i++){
                if(i%2==0){
                     answer+="수";
                }
                else{
                    answer+="박";
                }
            }
            
        }
       
        return answer;
    }
}