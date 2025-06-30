class Solution {
    public static int answer = 0;
    public int solution(int storey) {
        String s = String.valueOf(storey);
        while(storey>0){
            int digit = storey % 10;
            if(digit > 5){
                answer += (10-digit);
                storey += 10;
            }
            else if (digit < 5){
                answer += digit;
            }
            else{
                if((storey / 10) % 10 >= 5){
                    answer += 5;
                    storey += 10;
                }
                else{
                    answer += 5;
                }
            }
            storey /= 10;
        }
        return answer;
    }
}