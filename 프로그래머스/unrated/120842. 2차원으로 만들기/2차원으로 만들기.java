class Solution {
    public int[][] solution(int[] num_list, int n) {
        int[][] answer = new int[(num_list.length)/n][n];
        int l = 0;
        for(int i = 0; i < (num_list.length)/n; i++){
            for(int j = 0; j < n; j++){
                answer[i][j] = num_list[l++];
            }
//             answer[0][0] = num_list[0];
//             answer[0][1] = num_list[1];
//             answer[2][0] = num_list[3];
//             answer[2][1] = num_list[4];
        }
        
        return answer;
    }
}