import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int total = order.length;
        int n = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= total; i++) {
            while (!stack.isEmpty()) {
                if (stack.peek() == order[n]) {
                    stack.pop();
                    answer++;
                    n++;
                }
                else break;
            }
            if (order[n] != i) {
                stack.push(i);
            } else {
                answer++;
                n++;
            }
        }
        while(!stack.isEmpty()){
            if (stack.peek() == order[n]) {
                stack.pop();
                answer++;
                n++;
            }
            else break;
        }
        return answer;
    }
}