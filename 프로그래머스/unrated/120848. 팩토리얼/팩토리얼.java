class Solution {
    public int solution(int n) {
        int answer = 0;
        int i = 1;
        for(int j = 1; j <= n; j++){
            i*=j;
            if(n<i){
                j-=1;
                answer=j;
                break;
            }
            else if(n==j){
                answer=j;
                break;
            }
            else{
                continue;
            }
        }
        return answer;
    }
}