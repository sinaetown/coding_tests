class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                int temp = sizes[i][1];
                sizes[i][1] = sizes[i][0];
                sizes[i][0] = temp;
            }
        }
        int first = 0;
        int second = 0;
        for (int j = 0; j < sizes.length; j++) {
            if (first < sizes[j][0]) first = sizes[j][0];
            if (second < sizes[j][1]) second = sizes[j][1];
        }
        answer = first * second;
        return answer;
    }
}