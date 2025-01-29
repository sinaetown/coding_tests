class Solution {
    final int d = 1000000007;
    public int solution(int n) {
        int answer = 0;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1]%d + dp[i-2]%d;
        }
        return dp[n]%d;
    }
}