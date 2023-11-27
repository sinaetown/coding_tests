import java.util.*;

class Solution {
    public int solution(int a, int b, int c) {
        int answer = 0;
        List<Integer> l = new ArrayList<>();
        l.add(a);
        l.add(b);
        l.add(c);
        int count = 0;
        if(a==l.get(1)){
            if(a==l.get(2)){
                count=3;
            }
            else{
                count=2;
            }
        }
        else if(a==l.get(2)){
            count=2;
        }
        else if(b==l.get(2)){
            count=2;
        }
        else{
            count=1;
        }
        if(count==1){
            answer = a+b+c;
        }
        else if (count==2){
            answer = (a + b + c) * (a*a + b*b + c*c);
        }
        else{
            answer = (a + b + c) * (a*a + b*b + c*c)
                * (a*a*a + b*b*b + c*c*c);
        }
        return answer;
    }
}