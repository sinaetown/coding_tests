class Solution {
    static int[] grid;
    static int target;
    static int answer;
    public int solution(int n) {
        answer = 0;
        grid = new int[n];
        target=n;
        nQueen(0);
        return answer;
    }
    
    public void nQueen(int cnt){
        if(cnt == target) {
            answer++;
            return;
        }
        for(int i = 0; i < grid.length; i++){
            grid[cnt] = i;
            if(isPossible(cnt)) nQueen(cnt+1);
        }
    }
    
    public boolean isPossible(int cnt){
        for(int i = 0; i < cnt; i++){
            if(grid[cnt] == grid[i]) return false;
            if(Math.abs(cnt-i) == Math.abs(grid[cnt]-grid[i])) return false;
        }
        return true;
    }
}