class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        for(int start = 1; start <= r2; start++){
            long min = (int) Math.ceil(Math.sqrt(1.0*r1*r1 - 1.0*start*start));
            long max = (int) Math.floor(Math.sqrt(1.0*r2*r2 - 1.0*start*start));
            answer += (max-min+1);
        }
        return answer*4;
    }
    
}