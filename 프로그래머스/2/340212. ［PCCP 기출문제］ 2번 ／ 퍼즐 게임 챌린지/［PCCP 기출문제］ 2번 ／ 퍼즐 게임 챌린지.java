class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        return bs(diffs, times, limit);
    }
    
    public int bs(int[] diffs, int[] times, long limit){
        int max =  1;
        int min = 100000;
        while(max <= min){
            int level = (max+min)/2;
            long mid = cal(diffs, times, level);
            if(mid > limit){
                max = level+1;
            }
            else min = level-1;
        }
        return max;
    }
    
    public long cal(int[] diffs, int[] times, int level){
        long sum = 0;
        for(int i = 0; i < diffs.length; i++){
            if(diffs[i] <= level){
                sum += times[i];
            }
            else{
                sum += (long)(times[i-1]+times[i])*(long)(diffs[i]-level) + times[i];
            }
        }
        return sum;
    }
}