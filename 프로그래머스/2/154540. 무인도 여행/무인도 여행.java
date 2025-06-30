import java.util.*;

class Solution {
    public static int[][] grid;
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
    
    public int[] solution(String[] maps) {
        List<Integer> list = new ArrayList<>();
        int ind = 0;
        grid = new int[maps.length][maps[0].length()];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(maps[i].charAt(j) == 'X') grid[i][j] = 0;
                else grid[i][j] = Integer.parseInt(maps[i].split("")[j]);
            }
        }
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(!visited[i][j] && grid[i][j]!=0) list.add(bfs(visited, i, j));
            }
        }
        int[] answer = new int[list.size()];
        if(list.size() == 0) return new int[]{-1};
        for(int i : list) answer[ind++] = i;
        Arrays.sort(answer);
        return answer;
    }
    
    public static int bfs(boolean[][] visited, int startX, int startY){
        Queue<int[]> queue = new ArrayDeque<>();
        int sum = grid[startX][startY];
        queue.add(new int[]{startX, startY});
        visited[startX][startY]=true;
        while(!queue.isEmpty()){
            int[] polled = queue.poll();
            int polledX = polled[0];
            int polledY = polled[1];
            for(int i = 0; i < 4; i++){
                int nx = polledX+dx[i];
                int ny = polledY+dy[i];
                if(nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length ){
                    if(!visited[nx][ny] && grid[nx][ny] != 0){
                        visited[nx][ny]=true;
                        sum+=grid[nx][ny];
                        queue.add(new int[]{nx,ny});
                    }
                }
            }
        }
        return sum;
    }
}