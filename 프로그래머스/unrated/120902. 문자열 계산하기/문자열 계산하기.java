import java.lang.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public int solution(String my_string) {
        int answer = 0;
        Pattern p = Pattern.compile("\\d+");
        Matcher num = p.matcher(my_string);
        Pattern p_op = Pattern.compile("[\\-\\+]"); 
        Matcher op = p_op.matcher(my_string);
        
        // String resNum = "";
        List <Integer> resArr = new ArrayList<Integer>();
         List <Character> cArr = new ArrayList<Character>();
        int resNum = 0;
        String resOp = "";
        char c = ' ';
        while(num.find()) {
            resNum = Integer.valueOf(num.group());
            resArr.add(resNum);   
        }
        while(op.find()) {
            resOp = op.group();
            c = resOp.charAt(0);
            cArr.add(c);
            // System.out.println(resOp.charAt(0));
        }
        System.out.println(resArr);
        System.out.println(cArr);
        
        answer = resArr.get(0);
        for(int a = 1; a < resArr.size(); a++){
            if(cArr.get(a-1)=='+'){
                answer += resArr.get(a);
                System.out.println("PLUS : "+answer);
            }
            else if (cArr.get(a-1)=='-'){
                answer += (-1)*resArr.get(a);
                System.out.print("MINUS : "+answer);
            }
        }
        return answer;
    }
}