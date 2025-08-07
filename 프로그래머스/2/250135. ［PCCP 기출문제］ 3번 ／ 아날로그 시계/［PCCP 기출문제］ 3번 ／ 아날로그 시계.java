class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = -1;
        // 기준은 0시 0분 0초에서
        
        //0시 0분 0초~시작하는 시간동안 마주친 횟수
        int start = toSec(h1, m1, s1);
        //0시 0분 0초~끝나는 시간동안 마주친 횟수
        int end = toSec(h2, m2, s2);
        
        //이렇게 차이를 계산한 방법은 시작시간 자체가 알람이 울리는 시간일 경우, 그 횟수까지 제외한 것이기 때문에, 현재 시간에 알람이 울리는지를 체크해서 울린다면 1을 더해야 함
        answer = cal(end) - cal(start) + (now(start) ? 1 : 0);
        return answer;
    }
    
    public int cal(int time){
        //분심이 한 바퀴 도는 데 초침이랑 겹치는 횟수
        int sm = time*59/3600;
        //시침이 한 바퀴 도는 데 초침이랑 겹치는 횟수
        int sh = time*719/43200;
        
        //분침, 시침이 겹쳐지는 경우는 오직 12:00:00인 경우
        //만약 43200보다 크다면, 오후이기 때문에 두 번을 빼줘야 함
        //만약 작다면, 오전을 뜻하기 때문에 한 번만 빼줘도 됨
        int a = 43200 <= time ? 2 : 1;
        
        return sm + sh - a;
    }
    
     public int toSec(int h,int m,int s){
        return h*3600+m*60+s;
    }
    
    public boolean now(int time){
        return time*59%3600 == 0 || time*719%43200==0;
    }
}