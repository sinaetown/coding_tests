import java.util.*;
class Solution {
    public static int answer = 0;
    public static int N;
    public static int[][] Q;
    public static int[] ANS;
    public int solution(int n, int[][] q, int[] ans) {
        N = n;
        Q = q;
        ANS = ans;
        dfs(1,0, new ArrayList<>());
        return answer;
    }
    
    public void dfs(int start, int cnt, List<Integer> list){
        if(cnt == 5){
            if(check(list)) answer++;
            list = new ArrayList<>();
        }
        for(int i = start; i <= N; i++){
            list.add(i);
            dfs(i+1, cnt+1, list);
            list.remove(list.size()-1);
        }
    }
    
    public boolean check(List<Integer> list){
        for(int i = 0; i < Q.length; i++){
            int cnt = 0;
            for(int p = 0; p < 5; p++){
                for(int a : list){
                    if(a == Q[i][p]) cnt++;
                }
            }
            if(cnt != ANS[i]) return false;
        }
        return true;
    }
    
}