import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0 ; i < enemy.length; i++){
            n-=enemy[i];
            pq.add(enemy[i]);
            
            if(n<0){
                if(k>0){
                    n+=pq.poll();
                    k--;
                }
                else break;
            }
            answer++;
        }
        return answer;
    }
}