import java.util.*;

class Solution {
    public int[] dx = {0,0,1,-1};
    public int[] dy = {1,-1,0,0};
    public List<int[]> route;
    public int solution(int[][] land) {
        int answer = 0;
        int[] fuel = new int[land[0].length];
        
        boolean[][] visited = new boolean[land.length][land[0].length];
        for(int i = 0; i < land.length; i++){
            for(int j = 0; j < land[0].length; j++){
                if(land[i][j]==1 && !visited[i][j]){
                    route = new ArrayList<>();
                    bfs(land, new int[]{i,j}, visited);
                    int size = route.size();
                    Set<Integer> set = new HashSet<>();
                    for(int[] a : route){
                        int col = a[1];
                        if(!set.contains(col)){
                            fuel[col] += size;
                            set.add(col);
                        }
                    }
                }
            }
        }
        Arrays.sort(fuel);
        return fuel[fuel.length-1];
    }
    
    public void bfs(int[][] land, int[] start, boolean[][] visited){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{start[0], start[1]});
        visited[start[0]][start[1]] = true;
        route.add(new int[]{start[0],start[1]});
        while(!queue.isEmpty()){
            int[] polled = queue.poll();
            for(int i = 0; i < 4; i++){
                int nx = dx[i] + polled[0];
                int ny = dy[i] + polled[1];
                if(nx >= 0 && ny >= 0 && nx < land.length && ny < land[0].length){
                if(!visited[nx][ny] && land[nx][ny] == 1){
                    queue.add(new int[]{nx,ny});
                    route.add(new int[]{nx,ny});
                    visited[nx][ny] = true;
                }
            }
            }
        }
        
    }
}