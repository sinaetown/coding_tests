class Solution {
    public int solution(int balls, int share) {
        int answer = 0;
        int[][] matrix = new int[balls+1][balls+1];
        for(int i = 0; i < balls+1; i++){
            matrix[i][i] = 1;
            matrix[i][1] = i;
            matrix[i][0] = 1;
        }

        for(int i = 2; i <= balls; i++){
            for(int j = 1; j < i; j++){
                matrix[i][j] = matrix[i-1][j] + matrix[i-1][j-1];
            }
        }
        answer = matrix[balls][share];
        return answer; 
    }
}