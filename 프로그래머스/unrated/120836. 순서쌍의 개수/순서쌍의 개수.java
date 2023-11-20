class Solution {
    public int solution(int n) {
        int answer = 0;
        int i = 1;
        int j = n;
        while((i < j)){
            if(n%i==0){
                System.out.println(i+" "+j);
                answer++;
            }
           i++;
            if(n%i==0){
              j= n/i;  
            } 
            else{
                continue;
            }
        }
        
        if(i==j){
            answer*=2;
            answer++;
        }
        else{
            answer*=2;
        }        
        return answer;
    }
}