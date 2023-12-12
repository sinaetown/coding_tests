class Solution {
    public String solution(int[] numLog) {
        String answer = "";
        for(int i = 1 ; i < numLog.length; i++){
            int n = numLog[i] - numLog[i-1];
            if(n==1){
                answer+="w";
            }
            else if (n==-1){
                answer+="s";
            }
            else if(n==10){
                answer+="d";
            }
            else{
                answer+="a";
            }
        }
        return answer;
    }
}