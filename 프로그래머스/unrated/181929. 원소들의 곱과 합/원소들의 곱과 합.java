class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int mul1 = 1;
        int m = 0;
        for(int  i = 0; i < num_list.length; i++){
            mul1 *= num_list[i];
            m += num_list[i];

                        }
            if(mul1 < m*m){
                answer = 1;

        }
        return answer;
    }
}