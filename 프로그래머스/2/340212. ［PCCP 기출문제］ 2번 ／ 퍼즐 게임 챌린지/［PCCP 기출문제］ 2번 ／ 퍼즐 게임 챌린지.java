import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        long left = 1;
        long right = 0;
        for(int i : diffs) right = Math.max(right, i);
        while(left <= right){
            long mid = (left+right)/2;
            // 시간이 너무 많이 걸리면 숙련도를 높여
            if(solve(mid, diffs, times) > limit){ 
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return (int) left;
    }
    
    public long solve(long lv, int[] diffs, int[] times){
        long ans = 0; // 걸리는 시간
        // 시간이 많이 걸리는 이유는 숙련도가 낮기 때문
        ans += times[0];
        for(int i = 1; i < diffs.length; i++){ 
            if(diffs[i] <= lv) ans+=times[i];
            else{ //처음이 틀리는 경우는 없음
                long wrong = diffs[i]-lv; 
                long prev = times[i-1];
                long current = times[i];
                ans += ((prev + current) * wrong + current);
            }
        }
        return ans;
    }
}