import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        List<Integer> res = new ArrayList<>();
        List<Integer> given = new ArrayList<>();
        for(int n : numbers){
            given.add(n);
        }
        List<Integer> l = new ArrayList<>();
        l.add(0);
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        l.add(6);
        l.add(7);
        l.add(8);
        l.add(9);
        for(int i = 0; i < l.size(); i++){
            if(!(given.contains(l.get(i)))){
                res.add(l.get(i));
            }
        }
        for(int j : res){
            answer += j;
        }
        return answer;
    }
}