class Solution {
    public long solution(long n) {
        long answer = 0;
        double m = Math.sqrt(n);
        if(m%1==0){
            answer = (long)Math.pow(m+1,2);
        }
        else{
           answer = -1;
        }
        return answer;
    }
}