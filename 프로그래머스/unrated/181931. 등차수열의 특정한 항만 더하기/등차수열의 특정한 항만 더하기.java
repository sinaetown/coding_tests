import java.util.*;

class Solution {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        List<Boolean> incl = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int count = 0;
        for(boolean b : included){
            incl.add(b);
        }
        for(int i = 0; i < incl.size(); i++){
            if(incl.get(i)==true){
                res.add(count);
                count++;
            }
            else{
                count++;
            }
        }
        for(int i = 0; i < res.size(); i++){
            answer+= (a+d*(res.get(i)));
        }
        return answer;
    }
}