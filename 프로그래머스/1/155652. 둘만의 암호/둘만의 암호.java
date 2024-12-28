import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        List<String> valid = new ArrayList<>();
        String[] arr = skip.split("");
        List<String> skipList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) skipList.add(arr[i]);
        for (Character c = 'a'; c <= 'z'; c++) {
            if (!skipList.contains(Character.toString(c))) valid.add(Character.toString(c));
        }
        for (int a = 0; a < s.length(); a++) {
            if (valid.contains(Character.toString(s.charAt(a)))) {
                int ind = valid.indexOf(Character.toString(s.charAt(a))) + index;
                if (ind >= valid.size()) {
                    ind %= valid.size();
                }
                answer += valid.get(ind);
            }
        }
        return answer;
    }
}