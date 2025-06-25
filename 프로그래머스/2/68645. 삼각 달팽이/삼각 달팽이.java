class Solution {
    public int[] solution(int n) {
        int total = (n*(n+1))/2;
        int[] answer = new int[total];
        int[][] arr = new int[n][n];
        int x = -1, y = 0;
        int num = 1;
        for(int i = 0; i < n; ++i){
            for(int j = i; j < n; ++j){
                if(i%3==0) ++x; //세로
                else if(i%3==1) ++y; //가로
                else{ //대각선
                    --x;
                    --y;
                }
                arr[x][y]=num++;
            }
        }
        
        int idx = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                answer[idx++] = arr[i][j];
            }
        }
        return answer;
    }
}