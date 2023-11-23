import java.lang.Math;
import java.util.*;

class Solution {
    public String solution(String bin1, String bin2) {
        String answer = "";
        // change bin1 to decimal num:
        int dec1 = 0;
        int one_len = bin1.length();
        int temp = one_len-1;
        for(int i = 0; i < one_len; i++){
            dec1 += Math.pow(2,i) * Integer.valueOf(bin1.charAt(temp)-'0');
            temp--;
        }
        
        // change bin2 to decimal num:
        int dec2 = 0;
        int two_len = bin2.length();
        int temp2 = two_len-1;
        for(int i = 0; i < two_len; i++){
            dec2 += Math.pow(2,i) * Integer.valueOf(bin2.charAt(temp2)-'0');
            temp2--;
        }
        
        // change the sum to binary expression
        int sum = dec1+dec2;
        int numerator =sum;
        int remainder = 0;
        List <Integer> l = new ArrayList<Integer>();
        while(numerator != 0){
            remainder = numerator%2;
            numerator/=2;
            l.add(remainder);
        }
        
        if(sum == 0){
            answer = "0";
        }
        else{
            for(int i = l.size(); i > 0; i--){
            answer+=l.get(i-1);
        }
        }
        return answer;
    }
}