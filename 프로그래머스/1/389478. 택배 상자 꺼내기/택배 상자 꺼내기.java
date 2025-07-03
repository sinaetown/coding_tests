import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        boolean flag = false;
        int col = n/w;
        int[][] grid = new int[col+1][w];
        int cnt = 1;
        int[] target = new int[2];
        for(int i = 0; i < col+1; i++){
            for(int j = 0; j < w; j++){
                if(cnt > n) break;
                if(!flag){ //왼쪽부터
                    if(cnt == num) target = new int[]{i,j};
                    grid[i][j] = cnt++;
                }
                else{ //오른쪽부터
                    if(cnt == num) target = new int[]{i,w-j-1};
                    grid[i][w-j-1] = cnt++;
                }
            }
            if(!flag) flag=true;
            else flag = false;
        }
        System.out.println(Arrays.deepToString(grid));
        System.out.println(target[0]);
        System.out.println(target[1]);
        for(int i = target[0]; i < grid.length; i++){
            if(grid[i][target[1]]!=0) answer++;
        }
        return answer;
    }
}