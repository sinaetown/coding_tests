import java.util.*;
import java.lang.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        List<Character> given = new ArrayList<Character>();
        List<Character> tobeRemoved = new ArrayList<Character>();
        List<Character> visited = new ArrayList<Character>();

        for(int i = 0; i < s.length(); i++){
            given.add(s.charAt(i));
            if(!visited.contains(s.charAt(i))){
                visited.add(s.charAt(i));
            }
            else{ //already exists in visited but visited again
                tobeRemoved.add(s.charAt(i));
            }
        }
        
        //finding duplicates that are to be in given
        Set<Character> givenDup = new HashSet<Character>(given);
        
        //finding duplicates that are to be removed in to
        //HashSet to Array
        Set<Character> tobe = new HashSet<Character>(tobeRemoved);
        Character[] tobeArr = tobe.toArray(new Character[tobe.size()]); 
        for(int i = 0; i < tobe.size(); i++){
            if(givenDup.contains(tobeArr[i])){
                givenDup.remove(tobeArr[i]);
            }
        }
        
        Character[] answerOrder = givenDup.toArray(new Character[givenDup.size()]); 
        List<Character> cc = new ArrayList<Character>();
        for(int i = 0; i < answerOrder.length; i++){
            cc.add(answerOrder[i]);
        }
        Collections.sort(cc);
        for(int i = 0; i < cc.size(); i++){
            answer+=cc.get(i);
        }
        return answer;
    }
}