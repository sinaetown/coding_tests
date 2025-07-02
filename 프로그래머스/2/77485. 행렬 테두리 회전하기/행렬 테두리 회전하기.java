import java.util.*;

class Solution {
    public static int[][] grid;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        build(rows, columns);
        int ind = 0;
        for(int i = 0; i < queries.length; i++){
            answer[ind++] = rotate(queries[i]);
        }
        return answer;
    }
    
    public static int rotate(int[] query){
        int startX = query[0]; // 2
        int startY = query[1]; // 2
        int endX = query[2]; // 5
        int endY = query[3]; // 4
        int min = Integer.MAX_VALUE;
        
        int startTmp = grid[startX+1][startY];
        int tmp = grid[startX][endY];
        min = Math.min(min,Math.min(startTmp, tmp));
        for(int i = endY; i > startY; i--){
            grid[startX][i] = grid[startX][i-1];
            min = Math.min(min, grid[startX][i-1]);
        }
        // System.out.println(Arrays.deepToString(grid));
        
        int tmp2 = grid[endX][endY];
        min = Math.min(min,tmp2);
        for(int i = endX; i > startX; i--){
            grid[i][endY] = grid[i-1][endY];
            min = Math.min(min, grid[i-1][endY]);
        }
        grid[startX+1][endY] = tmp;
        
        tmp = grid[endX][startY];
        min = Math.min(min,tmp);
        for(int i = startY; i < endY; i++){
            grid[endX][i] = grid[endX][i+1];
            min = Math.min(min, grid[endX][i+1]);
        }
        grid[endX][endY-1] = tmp2;
        
        for(int i = startX; i < endX; i++){
            grid[i][startY] = grid[i+1][startY]; 
             min = Math.min(min, grid[i+1][startY]);
        }
        grid[endX-1][startY] = tmp;
        grid[startX][startY] = startTmp;
        return min;
    }
    
    public static void build(int rows, int columns){
        grid = new int[rows+1][columns+1];
        int ind = 1;
        for(int i = 1; i < rows+1; i++){
            for(int j = 1; j < columns+1; j++){
                grid[i][j] = ind++;
            }
        }
    }
}