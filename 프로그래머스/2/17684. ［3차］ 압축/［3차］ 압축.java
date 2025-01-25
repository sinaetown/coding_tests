import java.util.*;

class Solution {
    public int[] solution(String msg)  {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> dictionary = new HashMap<>();
        int n = 1;
        int after = 27;
        for (Character c = 'A'; c <= 'Z'; c++) {
            dictionary.put(Character.toString(c), n);
            n++;
        }
        int k = 0;
        l1:
        while (true) {
            for (int j = k + 1; j < msg.length() + 1; j++) {
                if (!dictionary.containsKey(msg.substring(k, j))) {
                    dictionary.put(msg.substring(k, j), after++);
                    list.add(dictionary.get(msg.substring(k, j - 1)));
                    k = j - 1;
                    break;
                }
                if (j == msg.length()) {
                    if (!dictionary.containsKey(msg.substring(k, j))) {
                        list.add(after);
                    } else {
                        list.add(dictionary.get(msg.substring(k, j)));
                    }
                    break l1;
                }
            }
        }
        int[] answer = new int[list.size()];
        int index = 0;
        for (int l : list) answer[index++] = l;
        return answer;
    }
}