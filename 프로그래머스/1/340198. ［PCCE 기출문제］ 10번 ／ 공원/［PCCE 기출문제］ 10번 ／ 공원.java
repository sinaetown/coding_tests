import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = 0;
        int[][] grid = new int[park.length][park[0].length];
        for(int i = 0; i < park.length; i++){
            for(int j = 0; j < park[0].length; j++){
                if(park[i][j].equals("-1")) grid[i][j] = 1;
                else grid[i][j] = -1;
            }
        }
        
        for(int i = 1; i < park.length; i++){
            for(int j = 1; j < park[0].length; j++){
                int up = grid[i-1][j];
                int down = grid[i][j-1];
                int upperleft = grid[i-1][j-1];
                if(up > 0 && down > 0 && upperleft > 0 && grid[i][j] > 0){
                    grid[i][j] = Math.min(upperleft, Math.min(up, down))+1;
                }
            }
        }
        Arrays.sort(mats);
        int ind = mats.length-1;
        while(ind >= 0){
             for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid[i].length; j++){
                if(mats[ind] == grid[i][j]) return mats[ind];
            }
        }
            ind--;
        }
       
        return -1;
    }
}