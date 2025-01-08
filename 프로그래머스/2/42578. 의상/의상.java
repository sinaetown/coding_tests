import java.util.*;
class Solution {
    public int solution(String[][] clothes){
        int answer = 1;
        Map<String, List<String>> map = new HashMap<>();
        List<String> arr = new ArrayList<>();
        for (int i = 0; i < clothes.length; i++) {
            if (!map.containsKey(clothes[i][1])) {
                arr.add(clothes[i][0]);
                map.put(clothes[i][1], arr);
            } else {
                List<String> updated = map.get(clothes[i][1]);
                updated.add(clothes[i][0]);
                map.put(clothes[i][1], updated);
            }
            arr = new ArrayList<>();
        }
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            answer *= map.get(next).size() + 1;
        }
        return answer - 1;
    }
}