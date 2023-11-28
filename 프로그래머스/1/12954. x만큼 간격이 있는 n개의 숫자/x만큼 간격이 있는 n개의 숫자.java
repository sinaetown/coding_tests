class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        int j = 1;
        answer[0] = x;
        for(int i = 0; i < n-1; i++){
            answer[j++] = answer[i]+x;
        }
        return answer;
    }
}