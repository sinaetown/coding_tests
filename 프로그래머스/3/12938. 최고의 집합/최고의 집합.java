import java.util.Arrays;

class Solution {
    public int[] solution(int n, int s) {
        if (n > s) return new int[]{-1};
        int[] answer = new int[n];
        int index = 0;
        int initial = s / n;
        Arrays.fill(answer, initial);
        s -= initial * n;
        while (s > 0) {
            answer[index % n] += 1;
            index++;
            s--;
        }
        Arrays.sort(answer);
        return answer;
    }
}