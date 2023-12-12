import java.util.*;
import java.lang.*;

class Solution {
    public String[] solution(String my_string) {
        String[] trimmed = my_string.trim().split(" ");
        System.out.print(Arrays.toString(trimmed));
        
        List<String> str_list = new ArrayList<>();
        for(String s : trimmed){
            if(!s.equals("")){
                str_list.add(s);
            }
        }
        
        String[] answer = new String[str_list.size()];
        int index = 0;
        for(int i  = 0 ; i <str_list.size(); i++){
            answer[index++] = str_list.get(i);
        }
       
        return answer;
    }
}