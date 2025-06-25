import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long goal = eachSum(queue1, queue2);
        if(goal*2%2 !=0) return -1;
        long sum1 = 0, sum2 = 0;
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        for(int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            sum1+=queue1[i];
        }
        for(int i = 0; i < queue2.length; i++) {
            q2.add(queue2[i]);
            sum2+=queue2[i];
        }
        while(true){
            if(answer > queue1.length * 2 + queue2.length * 2) break;
            if(sum1 <= 0) break;
            if(sum2 <= 0) break;
            if(q1.isEmpty()) break;
            if(q2.isEmpty()) break;
            if(sum1 == goal) return answer;
            else if(sum1 > goal){
                int popped = q1.remove();
                sum1-=popped;
                q2.add(popped);
                sum2+=popped;
                answer++;
            }
            else if(sum1 < goal){
                int popped = q2.remove();
                sum2-=popped;
                q1.add(popped);
                sum1+=popped;
                answer++;
            }
        }
        return -1;
    }
    
    public static long eachSum(int[] queue1, int[] queue2){
        long sum = 0;
        for(int i = 0; i < queue1.length; i++) sum += queue1[i];
        for(int i = 0; i < queue2.length; i++) sum += queue2[i];
        return sum/2;
    }
}