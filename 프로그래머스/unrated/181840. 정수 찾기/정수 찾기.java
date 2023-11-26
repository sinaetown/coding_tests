class Solution {
    public int solution(int[] num_list, int n) {
        int answer = 0;
        for(int f : num_list){
            if(n==f){
                answer = 1;
            }
        }
        return answer;
    }
}