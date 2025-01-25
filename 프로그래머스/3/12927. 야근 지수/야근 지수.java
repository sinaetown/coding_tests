import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int w : works) priorityQueue.offer(w);
        while (n > 0) {
            int work = priorityQueue.poll();
            if (work == 0) break;
            work--;
            priorityQueue.offer(work);
            n--;
        }
        for (int p : priorityQueue) answer += p * p;
        return answer;
    }
}