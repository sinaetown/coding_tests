import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = new_id;
        answer = step1(answer);
        answer = step2(answer);
        answer = step3(answer);
        answer = step4(answer);
        answer = step5(answer);
        answer = step6(answer);
        answer = step7(answer);
        return answer;
    }
    
    public String step7(String id){
        String answer = id;
        if(answer.length()<=2){
            char c = answer.charAt(answer.length()-1);
            while(answer.length()!=3){
                answer+=c;
            }
        }
        return answer;
    }
    
    public String step6(String id){
        String answer = id;
        if(answer.length()>=16){
            answer = answer.substring(0,15);
            if(answer.charAt(14)=='.') answer = answer.substring(0,14);
        }
        return answer;
    }
    
    public String step5(String id){
        if(id.isEmpty()) return "a";
        return id;
    }
    
    public String step4(String id){
        String answer = id;
        if(answer.startsWith(".")) answer = answer.substring(1,answer.length());
        if(answer.endsWith(".")) answer = answer.substring(0, answer.length()-1);
        return answer;
    }
    
    public String step3(String id){
        String answer = id.replaceAll("\\.{2,}", ".");
        return answer;
    }
    public String step2(String id){
        String answer = "";
        for(int i = 0; i < id.length(); i++){
            if(Character.isLetterOrDigit(id.charAt(i))) answer += id.charAt(i);
            if(id.charAt(i) == '-' || id.charAt(i) == '_' || id.charAt(i) == '.') answer += id.charAt(i);
        }
        return answer;
    }
    public String step1(String id){
        return id.toLowerCase();
    }
}