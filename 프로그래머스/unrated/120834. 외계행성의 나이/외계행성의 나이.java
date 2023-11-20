import java.util.*;
import java.lang.*;

class Solution {
    public String solution(int age) {
        String answer = "";
        String str_age;
        
        str_age = String.valueOf(age); //convert to string
        char[] sarr = new char[str_age.length()];
        
        int j = 0;
        for(int i = 0; i < str_age.length(); i++){
            sarr[j++] = str_age.charAt(i); //character로 들어감 ['2','3']
        }
        
        for(int i = 0; i < str_age.length(); i++){
           System.out.print((int)sarr[i]);
            char a = (char)(sarr[i] + 'A' - 16);
            answer+=a;
        }
        return answer;
    }
}