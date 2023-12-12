import java.util.*;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        Map<Integer, Integer> myMap = new HashMap<>();
        for(int i : array){
            myMap.put(i, myMap.getOrDefault(i,0)+1);
        }
        System.out.print(myMap);
        Iterator<Integer> k_iter = myMap.keySet().iterator();
        Iterator<Integer> v_iter = myMap.values().iterator();
        int max = v_iter.next();
        int it = 0;
        int max_k = k_iter.next();
        int k = 0;
        while(v_iter.hasNext()){
            it = v_iter.next();
            k = k_iter.next();
            if(max < it){
                max = it;
                max_k = k;
            }
        }
        
        Iterator<Integer> v_chk = myMap.values().iterator();
        int count = 0;
        while(v_chk.hasNext()){
         if(max == v_chk.next()){
            count++;
        }
        }
       
        if(count>1){
            max_k=-1;
        }
        answer=max_k;
        return answer;
    }
}