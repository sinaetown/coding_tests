import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        List<Character> list = new ArrayList<>();
        Deque<Character> order = new ArrayDeque<>();
        Deque<Character> given = new ArrayDeque<>();
        for (int s = 0; s < skill.length(); s++) list.add(skill.charAt(s));
        for (String t : skill_trees) {
            for (int s = 0; s < skill.length(); s++) order.add(skill.charAt(s));
            for (int i = 0; i < t.length(); i++) {
                if (list.contains(t.charAt(i))) {
                    given.add(t.charAt(i));
                }
            }
            while (!given.isEmpty()) {
                if (given.peekFirst() != order.peekFirst()) break;
                else {
                    order.removeFirst();
                    given.removeFirst();
                }
            }
            if (given.isEmpty()) answer++;
            order = new ArrayDeque<>();
            given = new ArrayDeque<>();
        }
        return answer;
    }
}