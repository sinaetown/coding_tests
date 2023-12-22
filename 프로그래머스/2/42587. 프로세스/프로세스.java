import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Deque<List<Integer>> deq = new ArrayDeque<>();
        for (int p = 0; p < priorities.length; p++) {
            deq.add(new ArrayList<>(Arrays.asList(priorities[p], p)));
        }

        // System.out.println("Deque: " + deq);

        boolean b = true;
        int count = 0;
        while (!deq.isEmpty()) {
            int max = findMax(deq);
            while (deq.peek().get(0) != max) {
                List<Integer> moving = deq.removeFirst(); //remove and add to the last
                deq.addLast(moving);
            }
            List<Integer> tobePolled = deq.poll();
            count++;
            if (tobePolled.get(1) == location) {
                // System.out.println(tobePolled.get(0) + ", " + tobePolled.get(1));
                // System.out.println("Count: "+count);
                answer = count;
                break;
            }
        }
        return answer;
    }

    static int findMax(Deque<List<Integer>> deq) {
        Deque<List<Integer>> copied = new ArrayDeque<>(deq);
        int max = Integer.MIN_VALUE;
        while (!copied.isEmpty()) {
            List<Integer> polled = copied.poll();
            max = Math.max(polled.get(0), max);
        }
        // System.out.println(max);
        return max;
//        return copied.getFirst();
    }
    
}