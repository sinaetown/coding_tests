class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        long[] price_list = new long[count];
        long sum = 0;
        int j = 0;
        for(int i = 1; j < count; i++){
            price_list[j++] = i*price; 
        }
        for(int i = 0; i < count; i++){
            sum += price_list[i];
        }
        answer = (sum>money) ? sum - money : 0;
        return answer;
    }
}