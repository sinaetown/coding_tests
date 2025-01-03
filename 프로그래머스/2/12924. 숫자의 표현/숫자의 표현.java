class Solution {
    public int solution(int n){
        int answer = 0;
        for (int i = 1; i <= n/2; i++) {
            int start = i;
            int sum = start;
            for (int j = start + 1; j <= n; j++) {
                sum += j;
                if(sum>n) break;
                if (sum == n) {
                    answer++;
                    break;
                }
            }
        }
        return answer + 1;
    }
}