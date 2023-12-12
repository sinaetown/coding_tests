import java.util.*;

class Solution {
    public int solution(String[] strArr) {
        int answer = 0;
        Map<Integer, Integer> my_map = new HashMap<>();
        for(String s : strArr){
            if(!my_map.containsKey(s.length())){
                my_map.put(s.length(), 1);
            }
            else{
                int count = my_map.get(s.length());
                my_map.put(s.length(),count+1);
            }
        }
        System.out.println(my_map);
        Iterator<Integer> iter = my_map.values().iterator();
        int max = iter.next();
        int it = 0;
        while(iter.hasNext()){
            it = iter.next();
            System.out.println(it);
            if(max < it){
                max = it;
            }
        }
        answer=max;
        return answer;
    }
}