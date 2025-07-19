class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int)end-(int)begin+1];
        //자기 자신을 제외한 약수들 중 최댓값 && 10,000,000보다는 작은 값
        int index = 0;
        for(long i = begin; i <= end; i++){
            answer[index++] = find(i);
        }
        return answer;
    }
    
    public int find(long num){
        int res = 1;
        if(num == 1) return 0;
        for(int i = 2; i * i <= num; i++){
            if(num % i == 0){
                if( (int)(num / i) <= 10000000){
                    res = Math.max(res, (int)(num / i));
                    break;
                }
                else{
                    res = Math.max(res, i);
                }
            }
        }
        return res;
    }
}