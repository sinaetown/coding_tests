import java.lang.*;

class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        String ind = "";
        for(int i = 0; i < seoul.length; i++){
            if(seoul[i].equals("Kim")){
                ind = String.valueOf(i);
            }
        }
        answer = "김서방은 " + ind+"에 있다";
        return answer;
    }
}