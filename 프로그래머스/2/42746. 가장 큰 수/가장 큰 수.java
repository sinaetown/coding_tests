import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String sub="";
        String[] num = new String[numbers.length];
        int index = 0;
        for(int i : numbers){
            num[index++] = String.valueOf(i);
        }
        Arrays.sort(num, (o1,o2)->(o2+o1).compareTo(o1+o2));
        for (String i : num) {
            sub += i;
        }
        if(sub.substring(0,1).equals("0")){
            answer = "0";
        }
        else{
            answer = sub;
        }
        return answer;
    }
}