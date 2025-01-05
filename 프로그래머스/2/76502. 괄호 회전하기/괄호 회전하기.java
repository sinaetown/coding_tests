import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        for (int p = 0; p < s.length(); p++) {
            boolean flag = false;
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (stack.isEmpty()) {
                    if (s.charAt(i) == '}' ||
                            s.charAt(i) == ']' ||
                            s.charAt(i) == ')'
                    ) {
                        flag = true;
                        break;
                    } else {
                        stack.add(s.charAt(i));
                    }
                } else {
                    if (s.charAt(i) == '{' ||
                            s.charAt(i) == '[' ||
                            s.charAt(i) == '(') {
                        stack.add(s.charAt(i));
                    } else if (stack.peek() == '{' && s.charAt(i) == '}'
                            || stack.peek() == '[' && s.charAt(i) == ']'
                            || stack.peek() == '(' && s.charAt(i) == ')') {
                        stack.pop();
                    }
                }
            }
            if (stack.isEmpty() && !flag) answer++;
            char c = s.charAt(0);
            s = s.substring(1) + c;
        }
        return answer;
    }
}