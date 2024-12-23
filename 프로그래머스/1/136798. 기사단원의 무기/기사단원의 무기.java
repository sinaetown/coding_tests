class Solution {
   public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] arr = count(number);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > limit) {
                answer += power;
            } else answer += arr[i];
        }
        return answer;
    }

    public int[] count(int number) {
        int[] answer = new int[number];
        int ind = 0;
        for (int i = 1; i <= number; i++) {
            int count = 0;
            for (int j = 1; j * j <= i; j++) {
                if (j * j == i) count++;
                else if (i % j == 0) count += 2;
            }
            answer[ind++] = count;
        }
        return answer;
    }
}