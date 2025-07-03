class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        for(int i = 0; i < schedules.length; i++){
            boolean b = chk(schedules[i], timelogs[i], startday);
            if(b) answer++;
        }
        return answer;
    }
    
    public boolean chk(int hope, int[] log, int startday){
        int hopeMin = toMin(hope);
        for(int i = 0; i < log.length; i++){
            if(!isWeek(i, startday)) continue;
            int attend = toMin(log[i]);
            if(hopeMin+10 < attend) return false;
            
        }
        return true;
    }
    
    public int toMin(int time){
        int hr = time/100;
        int min = time%100;
        return hr*60+min;
    }
    
    public boolean isWeek(int n, int startday){
        if((n+startday) % 7 == 6 || (n+startday) % 7 == 0) return false;
        return true;
    }
}