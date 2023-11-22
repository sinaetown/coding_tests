import java.lang.Math;
import java.lang.*;
import java.util.List; 
import java.util.ArrayList; 

class Solution {
    public String[] solution(String my_str, int n) {
        int len = my_str.length();
        String[] answer = new String[Math.round(len/n)+1];
        String[] answer_exact = new String[Math.round(len/n)];
        String ex = "halqothmre";
        String s = "";

        // System.out.print(ex.length());
        // s = ex.substring(9);
        // System.out.print(s);
        int j = 0;
        int count = 0;
        if(len%n == 0){
            for(int i = 0; i < len; i+=n){
            if(count != Math.round(len/n)){
                answer_exact[j++] = my_str.substring(i,i+n);
                count++;
            }
            else{
                answer_exact[Math.round(len/n)] = my_str.substring(i);
            }
        }
            answer = answer_exact;
        }
        else{
            for(int i = 0; i < len; i+=n){
            if(count != Math.round(len/n)){
                answer[j++] = my_str.substring(i,i+n);
                count++;
            }
            else{
                answer[Math.round(len/n)] = my_str.substring(i);
            }
        }
        }
        
        return answer;
    }
}