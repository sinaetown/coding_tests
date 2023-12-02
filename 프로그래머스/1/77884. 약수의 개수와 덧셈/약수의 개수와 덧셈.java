import java.util.*;

class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        int[] div = new int[right-left+1];
        List <Integer> l = new ArrayList<>();
        for(int i = left; i <= right; i++){
            for(int num = 1; num <= i; num++){
                 if(i%num==0){
                    l.add(num);
                }
                else{
                    continue;
                }
            }
        
            if(l.size()%2==0){
                answer+=i;
                l.clear();
            }
            else{
                answer-=i;
                l.clear();
            }
        }
        return answer;
    }
}