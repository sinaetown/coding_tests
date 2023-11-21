import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.*;
import java.util.*;

class Solution {
    public int solution(String my_string) {
        int answer = 0;
        List<Integer> l = new ArrayList<Integer>();
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(my_string);
        while(m.find()){
            l.add(Integer.valueOf(m.group()));
        }
        for(int i = 0; i < l.size(); i++){
            answer+=l.get(i);
        }
        return answer;
    }
}