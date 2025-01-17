class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int ind = 0;
        for (int p = 0; p < prices.length - 1; p++) {
            int cnt = 0;
            for (int i = p + 1; i < prices.length; i++) {
                if (prices[p] <= prices[i]) {
                    cnt++;
                } else {
                    cnt++;
                    break;
                }
            }
            answer[ind++] = cnt;
        }

        return answer;
    }
}