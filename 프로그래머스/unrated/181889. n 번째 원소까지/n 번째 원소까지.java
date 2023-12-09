class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[n];
        int j = 0;
        for(int i = 0; i < n; i++){
            answer[j++] = num_list[i];
        }
        return answer;
    }
}