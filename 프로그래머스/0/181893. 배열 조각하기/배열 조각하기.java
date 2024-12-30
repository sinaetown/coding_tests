import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        List<Integer> list = new ArrayList<>();
        List<Integer> updated = new ArrayList<>();
        for (int q = 0; q < arr.length; q++) list.add(arr[q]);
        for (int i = 0; i < query.length; i++) {
            if (i % 2 == 0) {
                for (int a = 0; a < query[i] + 1; a++) {
                    updated.add(list.get(a));
                }
            } else {
                for (int a = query[i]; a < list.size(); a++) {
                    updated.add(list.get(a));
                }
            }
            list = new ArrayList<>(updated);
            updated.clear();
        }
        int[] answer = new int[list.size()];
        int ind = 0;
        for (int z = 0; z < list.size(); z++) answer[ind++] = list.get(z);
        return answer;
    }
}