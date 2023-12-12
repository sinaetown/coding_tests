class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        String lowerpat = pat.toLowerCase();
        String lowermy = myString.toLowerCase();
        
        if (lowermy.contains(lowerpat)){
            answer= 1;
        }
        else{
            answer = 0;
        }
        return answer;
    }
}