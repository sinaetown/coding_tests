import java.util.*;

class Solution {
    public static int size;
    public static Queue<int[]>[] memo;
    public static int answer;
    
    public int solution(int[][] points, int[][] routes) {
        size = routes.length;
        memo = new ArrayDeque[size];
        for(int i = 0 ; i < size; i++){
            memo[i] = new ArrayDeque<>();
        }
        //경로 계산
        findRoute(points, routes);
        //충돌 계산
        collide();
        return answer;
    }
    
    public static void collide(){
        int cnt = 0;
        while(cnt != size){
            int[][] grid = new int[101][101];
            cnt = 0;
            for(int i = 0; i < size; i++){
                if(memo[i].isEmpty()){
                    cnt++;
                    continue;
                }
                int[] tmp = memo[i].poll();
                grid[tmp[0]][tmp[1]]++;
            }
             for(int i = 0; i < 101; i++){
                for(int j = 0; j < 101; j++){
                if(grid[i][j] > 1) answer++;
            }
        }
        }
    }
    
    public static void findRoute(int[][] points, int[][] routes){
        for(int i = 0; i < size; i++){
            int[] point = points[routes[i][0] - 1]; //starting point
            int x = point[0];
            int y = point[1];
            memo[i].add(new int[]{x,y});
            
            for(int j = 1; j < routes[0].length; j++){
                int[] nextPoint = points[routes[i][j] - 1];
                int nextX = nextPoint[0];
                int nextY = nextPoint[1];
                
                int nx = nextX - x;
                int ny = nextY - y;
                
                while(nx != 0){
                    if(nx > 0){
                        nx--;
                        x++;
                        memo[i].add(new int[]{x,y});
                    }
                    else{
                        nx++;
                        x--;
                        memo[i].add(new int[]{x,y});
                        
                    }
                }
                
                while(ny != 0){
                    if(ny > 0){
                        ny--;
                        y++;
                        memo[i].add(new int[]{x,y});
                    }
                    else{
                        ny++;
                        y--;
                        memo[i].add(new int[]{x,y});
                    }
                }
            }
        }
    }
    
    
}