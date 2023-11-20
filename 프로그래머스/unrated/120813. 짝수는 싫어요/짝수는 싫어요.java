class Solution {
    public int[] solution(int n) {
        int numofOdds = 0;
        for(int a = 0; a < n; a++){
            if(a%2==1){
                numofOdds++;
            }
        }
        
        if(n%2!=0){
            numofOdds+=1;
            numofOdds = (int)numofOdds;
        }
        int[] answer = new int[numofOdds];
        int j = 0;
        for (int i = 0; i <= n; i++){

            if(i%2==1){
                answer[j++] = i;
            }
        }
        return answer;
    }
}