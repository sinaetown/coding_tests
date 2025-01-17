class Solution {
     int answer = 0;

    public int solution(int[] numbers, int target) {
        int n = dfs(numbers.length, 0, 0, numbers, target);
        return answer;
    }

    public int dfs(int count, int i, int total, int[] numbers, int target) {
        if (count == i) {
            if (target == total) answer++;
        } else {
            dfs(count, i + 1, total + numbers[i], numbers, target);
            dfs(count, i + 1, total - numbers[i], numbers, target);
        }
        return total;
    }
}