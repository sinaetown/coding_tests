import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        String[] s = myStr.split("[a-c]+");
        List <String> l = new ArrayList<>();
        List <String> emp = new ArrayList<>();
        for(String ss :s){
            if(!ss.equals("")){
                l.add(ss);
            }
        }
         String[] answer = new String[l.size()];
        String[] empstr = new String[]{"EMPTY"};
        if(l.size()==0){
            answer = empstr;
        }
        else{
            for(int i = 0; i < l.size(); i++){
                answer[i] = l.get(i);
            }
        }
       
        
        return answer;
    }
}