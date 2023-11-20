class Solution {
    public int solution(int angle) {
        int answer = (angle > 0 & angle < 90) ? 1 : (angle == 90) ? 2 : (angle > 90 & angle < 180) ? 3 : 4;
        return answer;
    }
}