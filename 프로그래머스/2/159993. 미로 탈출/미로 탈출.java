import java.util.*;

class Solution {
    public static char[][] grid;
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static int[] start; 
    public static int[] lever; 
    
    public class Element{
        int x;
        int y;
        int time;
        char obj;
        
        public Element(int x, int y, int time, char obj){
            this.x=x;
            this.y=y;
            this.time=time;
            this.obj=obj;
        }
    }
    
    public int solution(String[] maps) {
        int answer = 0;
        grid = new char[maps.length][maps[0].length()];
        start = new int[2];
        lever = new int[2];
        build(maps);
        System.out.println(Arrays.toString(start));
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        int untilLever = activateLever(visited, start[0], start[1], 'L');
        if(untilLever == -1) return -1;
        // System.out.println(untilLever);
        
        visited = new boolean[maps.length][maps[0].length()];
        int untilEnd = activateLever(visited, lever[0], lever[1], 'E');
        if(untilEnd == -1) return -1;
        
        // System.out.println(untilEnd);
        
        return untilLever + untilEnd;
    }
    
    public int activateLever(boolean[][] visited, int startX, int startY, char destination){
        Queue<Element> queue = new ArrayDeque<>();
        if(destination == 'L'){
            queue.add(new Element(startX, startY, 0, 'S'));
        }
        else if(destination == 'E'){
            queue.add(new Element(startX, startY, 0, 'L'));
        }
        visited[startX][startY]=true;
        while(!queue.isEmpty()){
            Element polled = queue.poll();
            int polledX = polled.x;
            int polledY = polled.y;
            int polledTime = polled.time;
            int polledObj = polled.obj;
            if(polledObj == destination) return polledTime;
            for(int i = 0; i < 4; i++){
                int nx = dx[i]+polledX;
                int ny = dy[i]+polledY;
                if(nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length){
                    if(!visited[nx][ny] && grid[nx][ny] != 'X'){
                        visited[nx][ny] = true;
                        queue.add(new Element(nx, ny, polledTime+1, grid[nx][ny]));
                    }
                }
            }
        }
        return -1;
    }
    
    public void build(String[] maps){
        for(int i = 0; i < maps.length; i++){
            String line = maps[i];
            for(int j = 0; j < line.length(); j++){
                if(line.charAt(j)=='S') start = new int[]{i, j};
                else if(line.charAt(j)=='L') lever = new int[]{i, j};
                grid[i][j] = line.charAt(j);
            }
        }
    }
}