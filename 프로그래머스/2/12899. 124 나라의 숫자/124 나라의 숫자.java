class Solution {
    public String solution(int n) {
        String answer = "";
        while(n!=0){
            int left = n%3;
            if(left == 0) {
                left = 4;
                answer = String.valueOf(left) + answer;
                n-=1;
            }
            else{
                answer = String.valueOf(left) + answer;
            }
            n/=3;
        }
        return answer;
    }
}