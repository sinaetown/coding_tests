import java.util.*;

class Solution {
    public int[] solution(int n) {
       
        List<Integer> f = new ArrayList <Integer>();
        List<Integer> ff = new ArrayList <Integer>();
        List<Integer> res = new ArrayList <Integer>();
        for(int i = 2; i <= n ; i++){
            if(n%i == 0){
                f.add(i);
            }
        }
        System.out.print("F: " + f);
        
        for(int i = 0; i < f.size(); i++){
            for(int j = 2; j <= n ; j++){
                if(f.get(i)%j == 0){
                    ff.add(j);
                }
            }
            if(ff.size()>=2){
                // System.out.println("get out");
                ff.clear();
            }
            else{
                res.add(f.get(i));
                ff.clear();
            }
        }
        System.out.println(res);
        int[] answer = new int[res.size()];
        int ind = 0;
        for(int i = 0; i < res.size(); i++){
            answer[ind++] = res.get(i);     
        }
        return answer;
    }
}