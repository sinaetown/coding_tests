import java.util.*;

class Solution {
    public int[] solution(String my_string) {
       int[] answer = new int[52];
        Map<Character, Integer> mapping = new HashMap<>();
        for (int i = 0; i < my_string.length(); i++) {
            mapping.put(my_string.charAt(i), mapping.getOrDefault(my_string.charAt(i), 0) + 1);
        }
        for (Character c : mapping.keySet()) {
            if (Character.isUpperCase(c)) answer[c - 65] = mapping.get(c);
            else if (Character.isLowerCase(c)) answer[c - 97 + 26] = mapping.get(c);
        }
       
        return answer;
    }
}