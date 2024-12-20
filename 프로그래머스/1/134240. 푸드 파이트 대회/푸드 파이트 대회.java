class Solution {
    public String solution(int[] food) {
        String answer = "";
        String sub = "";
        for(int i = 0; i < food.length; i++){
            if(food[i]%2==1){
                food[i]-=1;
            }
            for(int j = 0; j < food[i]/2; j++){
                sub+=Integer.toString(i);
            }
        }
        answer=sub+"0";
        for(int k = sub.length()-1; k >=0; k--){
            answer+=sub.charAt(k);
        }
        return answer;
    }
}