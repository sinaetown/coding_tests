class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        int repeat = arr2[0].length;
        for (int a = 0; a < arr1.length; a++) {
            int ind = 0;
            for (int r = 0; r < repeat; r++) {
                int sum = 0;
                for (int aa = 0; aa < arr1[0].length; aa++) {
                    sum += arr1[a][aa] * arr2[aa][r];
                }
                answer[a][ind++] = sum;
            }
        }
        return answer;
    }
}