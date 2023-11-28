import java.util.*;
import java.lang.Math;

class Solution {
    public long solution(long n) {
        long answer = 0;
        //long -> compare each digit as long -> reverse sort
        //-> put them together by string -> convert to long
        String n_str = String.valueOf(n);
        int len = n_str.length();
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < len; i++){
            if(Character.isDigit(n_str.charAt(i))){
                l.add((n_str.charAt(i) - '0'));
            }
        }
        Collections.sort(l, Collections.reverseOrder());
        
        String s = "";
        for(int i : l){
            s+=i;
        }
        System.out.print(s);
        answer = Long.parseLong(s);
        return answer;
        }
        

}