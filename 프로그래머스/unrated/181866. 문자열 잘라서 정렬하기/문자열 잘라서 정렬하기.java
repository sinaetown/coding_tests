import java.util.*;

class Solution {
    public String[] solution(String myString) {
        String part = "";
        List<String> l = new ArrayList<>();
        for(int i = 0; i < myString.length(); i++){
            if(myString.charAt(i)!='x'){
                part+=myString.charAt(i);
            }
            else if((myString.charAt(i)=='x')){
                if(part.length()!=0){
                    l.add(part);
                }
                part="";
            }
        }
        if(part.length()!=0){
            l.add(part);
        }
        
        Collections.sort(l);
        String[] answer = new String[l.size()];
        for(int i = 0; i < l.size(); i++){
            answer[i] = l.get(i);
        }
        return answer;
    }
}