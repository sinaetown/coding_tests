import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        List<Integer> l = new ArrayList<>();
        List<Integer> past = new ArrayList<>();
        for(int q : arr){
            l.add(q);
        }
        for(int m = 0; m <= l.size(); m++){
            past.clear();
            for(int i = 0; i < l.size(); i++){
                past.add(l.get(i));
            }
            for(int i = 0; i < l.size(); i++){
            if(l.get(i)%2==0 && l.get(i)>=50){
                l.set(i, l.get(i)/2);
            }
            else if(l.get(i)%2==1 && l.get(i) < 50){
                l.set(i, l.get(i)*2+1);
            }
            else{
                l.set(i, l.get(i));
            }
        }
        if(past.equals(l)){
            answer = m;
            break;
        }
        }
        return answer;
    }
}