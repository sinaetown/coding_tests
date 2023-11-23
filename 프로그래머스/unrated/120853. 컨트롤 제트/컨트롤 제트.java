import java.util.regex.*;
import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Pattern p = Pattern.compile("\\d+");
        Pattern findZ = Pattern.compile("\\Z");
        Matcher pMatcher = p.matcher(s);
        Matcher zMatcher = findZ.matcher(s);
        
//         while(pMatcher.find()){
//             System.out.print(zMat.group());
//         }
        
        int sum = 0;
        String[] splitted = new String[s.length()];
        int minus = 0;
        int i = 0;
        splitted = s.split(" ");
        for(int a = 0; a < splitted.length; a++){
            if(!splitted[a].equals("Z")){
                i = Integer.valueOf(splitted[a]);
                sum += i;
            }
            else if(splitted[a].equals("Z")){
                minus += Integer.valueOf(splitted[a-1]);
            }
        }
        int res = sum - minus;
        answer = res;
        return answer;
    }
}