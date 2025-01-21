import java.util.*;

class Solution {
    public int[] solution(String s) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        String num = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{') {
                sub = new ArrayList<>();
            } else if (s.charAt(i) == '}') {
                sub.add(Integer.parseInt(num));
                list.add(new ArrayList<>(sub));
            } else if (Character.isDigit(s.charAt(i))) {
                num += Character.toString(s.charAt(i));
            }
            else if(s.charAt(i)==','){
                sub.add(Integer.parseInt(num));
                num = "";
            }
        }
        list.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.size() - o2.size();
            }
        });
        List<Integer> tuple = new ArrayList<>();
        for (int a = 0; a < list.size(); a++) {
            for (int b = 0; b < list.get(a).size(); b++) {
                if (!tuple.contains(list.get(a).get(b))) tuple.add(list.get(a).get(b));
            }
        }
        int[] answer = new int[tuple.size()];
        int ind = 0;
        for (int i : tuple) answer[ind++] = i;
        return answer;
    }
}