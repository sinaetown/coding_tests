import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        Deque<String> queue1 = new ArrayDeque<>();
        Deque<String> queue2 = new ArrayDeque<>();
        for (int i = 0; i < cards1.length; i++) {
            queue1.add(cards1[i]);
        }
        for (int j = 0; j < cards2.length; j++) {
            queue2.add(cards2[j]);
        }
        for (int g = 0; g < goal.length; g++) {
            if (!queue1.isEmpty() && queue1.peekFirst().equals(goal[g])) {
                queue1.pop();
            } else if (!queue2.isEmpty() && queue2.peekFirst().equals(goal[g])) {
                queue2.pop();
            } else return "No";
        }
        return answer;
    }
}