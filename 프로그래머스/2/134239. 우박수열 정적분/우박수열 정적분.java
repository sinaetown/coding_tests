import java.util.*;

class Solution {
    public List<Integer> list;
    public double[] answer;
    public double[] dp;
    public double[] solution(int k, int[][] ranges) {
        answer = new double[ranges.length];
        list = new ArrayList<>();
        list.add(k);
        collatz(k);
        // System.out.println(list);
        dp = new double[list.size()];
        area();
        // System.out.println(Arrays.toString(dp));
        for(int i = 0; i < ranges.length; i++){
            int x = ranges[i][0];
            int y = ranges[i][1]+list.size()-1;
            if(y>x){
                double val = dp[y]-dp[x];
                String str = String.format("%.1f", val);
                answer[i] = (Double.parseDouble(str));
            }
            else if(x>y) answer[i] = -1;
            else answer[i] = 0;
        }
        return answer;
    }
    
    public void area(){
        for(int i = 1; i < dp.length; i++){
            dp[i] = (double)(list.get(i-1) + list.get(i))/2 + dp[i-1];
        }
    }
    
    public void collatz(int k){
        if(k == 1) return;
        if(k % 2 == 0){
            k /= 2;
        }
        else{
            k*=3;
            k++;
        }
        list.add(k);
        collatz(k);
    }
}