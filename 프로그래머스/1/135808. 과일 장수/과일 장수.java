import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> total = new ArrayList<>();
        for (int s = 0; s < score.length; s++) {
            list.add(score[s]);
        }
        list.sort(null);
        ArrayList<Integer> sub = new ArrayList<>();
        int start = list.size() - 1;
        for (int i = 0; i < list.size() / m; i++) {
            for (int j = 0; j < m; j++) {
                sub.add(list.get(start--));
            }
            total.add(new ArrayList<>(sub));
            sub.clear();
        }
        for (int t = 0; t < total.size(); t++) {
            answer += total.get(t).get(m - 1) * m;
        }
        return answer;
    }
}