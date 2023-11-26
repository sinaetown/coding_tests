class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        int mulRes = 2*a*b;
        
        String as = String.valueOf(a);
        String bs = String.valueOf(b);
        
        String s = as+bs;
        int sum = Integer.parseInt(s);
        
        if(sum >= mulRes){
            answer = sum;
        }
        else{
            answer = mulRes;
        }
        return answer;
    }
}