import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeSet<Integer> ts = new TreeSet<>();
for (String opStr : operations) {
      StringTokenizer st = new StringTokenizer(opStr);
            if (st.nextToken().equals("I")) {
                int value = Integer.parseInt(st.nextToken());
        ts.add(value);
    } else if (!ts.isEmpty() && opStr.equals("D 1")) {
        ts.remove(ts.last());
    } else if (!ts.isEmpty() && opStr.equals("D -1")) {
        ts.remove(ts.first());
    }
}
return ts.isEmpty() ? new int[] {0, 0} : new int[] {ts.last(), ts.first()};
    }
}