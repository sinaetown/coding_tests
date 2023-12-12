class Solution {
    public String solution(String my_string, int m, int c) {
        String answer = "";
        char[][] matrix = new char[my_string.length()/m][m];
        int k = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = my_string.charAt(k++);
            }
        }
        for(int i = 0; i < matrix.length; i++){
            answer += matrix[i][c-1];
        }
        return answer;
    }
}