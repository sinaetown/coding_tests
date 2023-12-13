import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer> pq = new PriorityQueue<>();
        boolean chk = true;
        int new_sco = 0;
        int least = 0;
        int second_least = 0;
        for(int s : scoville){
            pq.add(s);
        }
        while(chk){
            if(pq.peek()>=K){
                chk=false;
            }
            else{
                if(pq.size()==1){
                    answer = -1;
                    chk=false;
                }
                else{
                    least = pq.poll();
                    second_least = pq.poll();
                    new_sco = least+(second_least*2);
                    pq.add(new_sco);
                    answer++;
                }
            }
        }
        return answer;
    }
}