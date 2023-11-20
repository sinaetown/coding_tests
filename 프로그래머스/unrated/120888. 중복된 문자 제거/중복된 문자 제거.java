import java.util.*; 
class Solution {
    public String solution(String my_string) {
        String answer = "";
        List <Character> l = new ArrayList<Character>();
        
        for(int i = 0; i < my_string.length(); i++){

            if(!(l.contains(my_string.charAt(i)))){
                l.add(my_string.charAt(i));
                answer+=my_string.charAt(i);
            }
            else{
                continue;
            }
        }
        return answer;
    }
}