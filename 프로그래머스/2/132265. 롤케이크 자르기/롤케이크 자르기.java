import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> first = new HashMap<>();
        Set<Integer> second = new HashSet<>();
        for (int i = 0; i < topping.length; i++) {
            if (!first.containsKey(topping[i])) {
                first.put(topping[i], 1);
            } else {
                first.put(topping[i], first.get(topping[i]) + 1);
            }
        }
        for (int t = 0; t < topping.length; t++) {
            first.put(topping[t], first.get(topping[t]) - 1);
            second.add(topping[t]);
            if (first.get(topping[t]) == 0) first.remove(topping[t]);
            if (first.size() == second.size()) answer++;
        }
        return answer;
    }
}