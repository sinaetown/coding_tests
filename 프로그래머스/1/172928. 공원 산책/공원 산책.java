import java.util.*;

class Solution {
    public static char[][] grid;
    public static int nx = 0;
    public static int ny = 0;
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        int[] start = new int[2];
        grid = new char[park.length][park[0].length()];
        for(int i = 0; i < park.length; i++){
            for(int j = 0; j < park[i].length(); j++){
                grid[i][j] = park[i].charAt(j);
                if(grid[i][j]=='S') start = new int[]{i,j};
            }
        }
        move(routes, 0, start);
        return new int[]{nx, ny};
    }
    
    public void move(String[] routes, int i, int[] current){
        if(i == routes.length) return;
        String[] r = routes[i].split(" ");
        String direction = r[0];
        int steps = Integer.parseInt(r[1]);
        int currentX = current[0];
        int currentY = current[1];
        if(isValid(currentX, currentY, direction, steps)){
            if(direction.equals("N")) currentX-=steps;
            if(direction.equals("S")) currentX+=steps;
            if(direction.equals("W")) currentY-=steps;
            if(direction.equals("E")) currentY+=steps;
        }
        nx = currentX;
        ny = currentY;
        move(routes, i+1, new int[]{nx, ny});          
    }
    
    public boolean isValid(int x, int y, String direction, int steps){
        int afterX = x, afterY = y;
        if(direction.equals("N")) {
            for(int i = 0; i < steps; i++){
                afterX--;
                if(afterX < 0 || afterY < 0 || afterX >= grid.length || afterY >= grid[0].length || grid[afterX][afterY] == 'X') return false;
            }
        }
        if(direction.equals("S")) {
            for(int i = 0; i < steps; i++){
                afterX++;
                if(afterX < 0 || afterY < 0 || afterX >= grid.length || afterY >= grid[0].length || grid[afterX][afterY] == 'X') return false;
            }
        }
        if(direction.equals("W")) {
            for(int i = 0; i < steps; i++){
                afterY--;
                if(afterX < 0 || afterY < 0 || afterX >= grid.length || afterY >= grid[0].length || grid[afterX][afterY] == 'X') return false;
            }
        }
        if(direction.equals("E")) {
            for(int i = 0; i < steps; i++){
                afterY++;
                if(afterX < 0 || afterY < 0 || afterX >= grid.length || afterY >=grid[0].length || grid[afterX][afterY] == 'X') return false;
            }
        }
        return true;
    }
    
    
    
}