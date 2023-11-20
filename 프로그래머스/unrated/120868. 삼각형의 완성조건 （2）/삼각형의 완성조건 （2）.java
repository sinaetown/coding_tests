class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        int given_max = sides[0];
        int given_min = sides[1];
        
        if(given_max < sides[1]){
            given_max=sides[1];
            given_min=sides[0];
        }
        
         int lastSide = given_max;
        //case 1 when given_max is the larest among three:
        for(int i = 1; i < given_max; i++){
            if(i+given_min > given_max){
                answer++;
            }
            else{
                answer+=0;
            }
        }
        
        //case 2 when lastSide is the largest among three:
        for(int j = lastSide; j < given_max + given_min; j++){
            answer++;
        }
        return answer;
    }
}