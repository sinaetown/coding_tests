import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.sort(null);
        for (int i = 0; i < list.size(); i++) {
            if (!map.containsKey(list.get(i))) {
                map.put(list.get(i), 1);
            } else map.put(list.get(i), map.get(list.get(i)) + 1);
        }
        if (map.size() == 4) return list.get(0);
        if (map.size() == 1) return 1111 * list.get(0);
        if (map.size() == 3) {
            int three = 1;
            Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, Integer> next = it.next();
                if (next.getValue() == 1) {
                    three *= next.getKey();
                }
            }
            return three;
        }
        if (map.size() == 2) {
            Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
            int p3 = 0;
            int q3 = 0;
            int p2 = 0;
            int q2 = 0;
            boolean flag = false;
            while (it.hasNext()) {
                Map.Entry<Integer, Integer> next = it.next();
                if (next.getValue() == 3) p3 = next.getKey();
                if (next.getValue() == 1) q3 = next.getKey();
                else if (next.getValue() == 2) {
                    if (!flag) {
                        p2 = next.getKey();
                        flag = true;
                    } else {
                        q2 = next.getKey();
                        return (p2 + q2) * (Math.abs(p2 - q2));
                    }
                }
                if(q3!=0 && p3!=0) return (10 * p3 + q3) * (10 * p3 + q3);

            }
        }
        return answer;
    }
}