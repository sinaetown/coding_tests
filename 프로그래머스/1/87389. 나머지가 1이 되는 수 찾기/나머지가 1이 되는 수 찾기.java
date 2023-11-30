class Solution {
    public int solution(int n) {
        int answer = 1;
        int i = 1;
        while(answer>0){
            if(n%answer==1){
                return answer;
            }
            else{
                answer+=1;
                continue;
            }
            
        }
        return answer;
    }
}