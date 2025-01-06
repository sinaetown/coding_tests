import java.util.*;
import java.util.Map.Entry;
class Solution {
    public int solution(int k, int[] tangerine){
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> sorted = new LinkedHashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < tangerine.length; i++) {
            if (!map.containsKey(tangerine[i])) map.put(tangerine[i], 1);
            else map.put(tangerine[i], map.get(tangerine[i]) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(entry.getValue());
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int l : list) {
           if(k<=0){
               break;
           }
           k-=l;
           answer++;
        }
       
        return answer;
    }
}