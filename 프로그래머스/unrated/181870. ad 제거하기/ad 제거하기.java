import java.util.*;

class Solution {
    public String[] solution(String[] strArr) {
       
        List<String> l = new ArrayList<>();
        for(String s : strArr){
            if(!s.contains("ad")){
                l.add(s);
            }
        }
         String[] answer = new String[l.size()];
         for(int i = 0; i < l.size(); i++){
             answer[i] = l.get(i);
         }
        return answer;
    }
}