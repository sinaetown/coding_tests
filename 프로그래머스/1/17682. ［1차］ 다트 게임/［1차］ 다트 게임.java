import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < dartResult.length(); i++) {
            if (Character.isDigit(dartResult.charAt(i))) {
                if (Character.isDigit(dartResult.charAt(i + 1))) {
                    stack.push(10);
                      i++;

                } else {
                    stack.push(Integer.parseInt(String.valueOf(dartResult.charAt(i))));
                }
            } else if (Character.isAlphabetic(dartResult.charAt(i))) {
                if (dartResult.charAt(i) == 'D') {
                    int num = stack.pop();
                    stack.push(num * num);
                } else if (dartResult.charAt(i) == 'T') {
                    int num = stack.pop();
                    stack.push(num * num * num);
                }
            } else if (dartResult.charAt(i) == '*') {
                if (stack.size() == 1) {
                    int num = stack.pop();
                    stack.push(num * 2);
                } else if (stack.size() >= 2) {
                    int top = stack.pop();
                    int bottom = stack.pop();
                    stack.push(bottom * 2);
                    stack.push(top * 2);
                }
            } else if (dartResult.charAt(i) == '#') {
                int num = stack.pop();
                stack.push(num * (-1));
            }
        }
        while(!stack.isEmpty()){
            answer+=stack.pop();
        }
        return answer;
    }
}