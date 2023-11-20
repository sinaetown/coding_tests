import java.lang.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int l = lcm(6, n);
        answer = l/6;
        return answer;
    }
    
    public int gcd (int a, int b){
        if(b==0) return a;
        else{
            return gcd(b, a%b);
        }
    }
    
    public int lcm (int a, int b){
        return (Math.abs(a*b)) / gcd(a, b);
    }
}
