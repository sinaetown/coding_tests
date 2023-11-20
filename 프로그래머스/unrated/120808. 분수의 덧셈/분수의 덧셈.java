class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int d = denom1*denom2;
        int n = numer1*denom2 + numer2*denom1;
        
        int g = gcd(n,d);
        
        int[] answer = {n/g,d/g};
        return answer;
    }
    
    public int gcd(int a, int b){
        if(a<=b){
            int temp = a;
            a = b;
            b = temp;
        }
        if(b==0){
            return a;
        }
        return gcd(b, a%b);
}
}