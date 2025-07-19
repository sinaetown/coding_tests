import java.util.*;

class Solution {
    public static int[] CARDS;
    public static boolean[] visited;
    public static int cnt;
    public int solution(int[] cards) {
        int answer = 0;
        CARDS = cards;
        visited = new boolean[cards.length+1];
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); //max heap
        for(int i = 0; i < CARDS.length; i++){
            cnt = 1;
            if(!visited[CARDS[i]]){
                visited[CARDS[i]] = true;
                isCycle(CARDS[i], CARDS[i]);
                pq.add(cnt);
            }
        }
        System.out.println(pq);
        if(pq.size() == 1) return 0;
        return pq.poll() * pq.poll();
    }
    
    // cycle이 만들어지는 가장 긴 그래프 두 개 찾기
    public void isCycle(int current, int target){
        if(CARDS[current-1] == target) return;
        else{
            if(!visited[CARDS[current-1]]){
                visited[CARDS[current-1]] = true;
                cnt++;
                isCycle(CARDS[current-1], target);
            }
        }
    }
}