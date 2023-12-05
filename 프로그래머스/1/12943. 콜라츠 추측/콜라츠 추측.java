import java.math.BigDecimal; 
class Solution {
    public int solution(int num) {
        int answer = 0;
        int count = 0;
        BigDecimal bd = new BigDecimal(String.valueOf(num));
        BigDecimal one = new BigDecimal(String.valueOf(1));
        BigDecimal two = new BigDecimal(String.valueOf(2));
        BigDecimal three = new BigDecimal(String.valueOf(3));
        BigDecimal zero = new BigDecimal(String.valueOf(0));
        
        System.out.print(bd);
        while(!bd.equals(one)){
            if((bd.remainder(two)).equals(zero)){
            bd=(bd.divide(two));
            count++;
            }
            
            else{
            bd=((bd.multiply(three)).add(one));
            count++;
            }
        }
        if(count > 500){
            return -1;
        }
        else{
             answer = count;
       
        }
        return answer;
    }
}