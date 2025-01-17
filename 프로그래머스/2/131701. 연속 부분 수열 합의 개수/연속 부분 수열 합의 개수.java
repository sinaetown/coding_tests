import java.util.*;

class Solution {
     public  Set<Integer> set = new HashSet<>();

    public  int solution(int[] elements) {
        for (int i = 1; i <= elements.length; i++) {
            sub(i, elements);
        }
        return set.size();
    }

    public  void sub(int i, int[] elements) {
        for (int start = 0; start < elements.length; start++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (start + j >= elements.length) {
                    list.add(elements[(start + j) % elements.length]);
                } else {
                    list.add(elements[start + j]);
                }
            }
            int sum = 0;
            for (int l : list) sum += l;
            set.add(sum);
        }
    }
}