import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        List<String> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if (i % n == 0) count++;
            if (i == 0) {
                list.add(words[i]);
            } else {
                String prev = words[i - 1];
                if (list.contains(words[i])) {
                    return new int[]{(i % n) + 1, count};
                } else if (!words[i].startsWith(Character.toString(prev.charAt(prev.length() - 1)))) {
                    return new int[]{(i % n) + 1, count};
                } else {
                    list.add(words[i]);
                }
            }
        }
        return answer;
    }
}