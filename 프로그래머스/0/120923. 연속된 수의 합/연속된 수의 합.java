class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int additional = 0;
        for (int i = 0; i < num; i++) {
            additional += i;
        }
        total -= additional;
        total /= num;
        int ind = 0;
        for (int t = 0; t < num; t++) {
            answer[ind++] = total++;
        }
        return answer;
    }
}