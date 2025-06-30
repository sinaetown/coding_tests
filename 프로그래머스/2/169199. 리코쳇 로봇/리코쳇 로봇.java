import java.util.*;

class Solution {
    public static char[][] grid;
    public static boolean[][] visited;
    public static int answer;
    public int solution(String[] board) {
        answer = Integer.MAX_VALUE;
        int[] start = new int[2];
        grid = new char[board.length][board[0].length()];
        visited = new boolean[board.length][board[0].length()];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length(); j++){
                grid[i][j] = board[i].charAt(j);
                if(grid[i][j] == 'R') start = new int[]{i,j};
            }
        }
        bfs(start[0], start[1]);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    
    public int bfs(int startX, int startY){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{startX, startY, 0});
        visited[startX][startY]=true;
        while(!queue.isEmpty()){
            int[] polled = queue.poll();
            int polledX = polled[0];
            int polledY = polled[1];
            int count = polled[2];
            if(grid[polledX][polledY] == 'G'){
                answer = Math.min(answer, count);
            }
            //1 up 2 down 3 right 4 left
            for(int i = 1; i <= 4; i++){
                int[] moved = slide(polledX, polledY, i);
                // System.out.println(Arrays.toString(moved));
                if(!visited[moved[0]][moved[1]]){
                    visited[moved[0]][moved[1]]=true;
                    queue.add(new int[]{moved[0], moved[1], count+1});
                }
            }
        }
        return -1;
    }
    
    public int[] slide(int polledX, int polledY, int direction){
        int nx = polledX;
        int ny = polledY;
        
        while(true){
            int nextX = nx;
            int nextY = ny;
            if(direction == 1) nextX--;
            if(direction == 2) nextX++;
            if(direction == 3) nextY++;
            if(direction == 4) nextY--;
            if(isBlocked(nextX, nextY)) break;
            nx = nextX;
            ny = nextY;
        }
        return new int[]{nx, ny};
    }
    
    public boolean isBlocked(int nx, int ny){
        if(nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length || grid[nx][ny] == 'D') return true;
        return false;
    }
}