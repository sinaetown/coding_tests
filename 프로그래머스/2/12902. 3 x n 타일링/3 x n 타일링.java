class Solution {
    public int solution(int n) {
        int answer = 0;
        long[] dp = new long[n+1];
        dp[2] = 3;
        for(int i = 4; i<= n; i++){
            dp[i] = dp[i-2] * dp[2] + 2;
            
            for(int j = 2; j <= i-4; j+=2){
                dp[i] += dp[j]*2;
            }
            dp[i]%=1000000007;
        }
        return (int)dp[n];
    }
}