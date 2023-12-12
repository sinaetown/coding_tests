import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> myMap = new HashMap<>();
        for(String p : participant){
            myMap.put(p, myMap.getOrDefault(p, 0)+1);
        }
        for(String c : completion){
            if(myMap.get(c)==1){
                myMap.remove(c);
            }
            else{
                myMap.put(c,myMap.get(c)-1);
            }
        }
        System.out.println(myMap);
        for(String s : myMap.keySet()){
            answer+=s;
        }
        return answer;
    }
}