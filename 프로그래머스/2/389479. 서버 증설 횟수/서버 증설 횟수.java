import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int servers = 0;
        int created = 0;
        int time = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        for(int p : players){
            time++;
            int cnt = 0;
            // 시간 지난 서버 삭제
            while(!queue.isEmpty() && queue.peek()==time){
                queue.poll();
                cnt++;
            }
            servers-=cnt;
            // 인원 기반으로 서버 개수 충족 확인
            // 1) 부족 시, 서버 증설하면서 스택에 빼야하는 시간으로 서버 집어넣기
            if(p >= m * servers){
                int more = p/m - servers;
                created+=more;
                servers+=more;
                for(int i = 0; i < more; i++){
                    queue.add(time+k);
                }
            }
            // 2) 충족 시, continue
            
            
        }
        return created;
    }
}