import java.util.*;

class Solution {
    public String solution(String my_string, int[] indices) {
        String answer = "";
        String s= my_string;
        List<Integer> l = new ArrayList<>();
        List<Integer> left = new ArrayList<>();
        Arrays.sort(indices);
        for(int i : indices){
            l.add(i);
        }
        for(int i = 0; i < my_string.length();i++){
            if(!l.contains(i)){
                left.add(i);
            }
        }
        
        for(int i = 0; i < left.size(); i++){
            answer+=my_string.charAt(left.get(i));
        }
        return answer;
    }
}