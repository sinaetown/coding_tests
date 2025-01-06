class Solution {
    public int solution(int n) {
        int[] dp = new int[n + 1];
        if (n == 0) return 0;
        if (n == 1) return 1;
        else {
            dp[0] = 0;
            dp[1] = 1;
            if (n >= 2) {
                for (int i = 2; i <= n; i++) {
                    dp[i] = dp[i - 1] % 1234567 + dp[i - 2] % 1234567;
                }
            }
        }
        return dp[n] % 1234567;
    }
}