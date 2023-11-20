import java.util.*;

class Solution {
    public int solution(String my_string) {
        int answer = 0;
        int count= 0;
        char[] c = new char[my_string.length()];
        int j = 0;
        for(int i = 0; i < my_string.length(); i++){
            if(my_string.charAt(i) == '1' || 
               my_string.charAt(i) == '2' || 
               my_string.charAt(i) == '3'||
               my_string.charAt(i) == '4'|| 
               my_string.charAt(i) == '5'||
               my_string.charAt(i) == '6'||
               my_string.charAt(i) == '7'||
               my_string.charAt(i) == '8'||
               my_string.charAt(i) == '9'){
                c[j++] = my_string.charAt(i);  
                count++;
            }
        }
        for(int a = 0; a < count; a++){
                answer+=Character.getNumericValue(c[a]);
                System.out.println(answer);
        }
        return answer;
    }
}