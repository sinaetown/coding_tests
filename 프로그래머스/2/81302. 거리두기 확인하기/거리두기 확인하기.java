import java.util.*;

class Solution {
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static char[][] grid;
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        int ind = 0;
        //P기준으로 맨해튼 거리 2까지만 확인
        //그 거리 내에 P가 없으면 ok
        //그 거리 내에 P가 있으면 not ok
        //그 거리내에 
        //O가 하나라도 있다면 not ok
        //O가 발견이 되지 않으면 ok
        for(String[] place : places){
            answer[ind++] = chk(place);
        }
        return answer;
    }
    
    public int chk(String[] place){
        grid = new char[5][5];
        List<int[]> p_pos = new ArrayList<>();
        //grid 만들기
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(place[i].charAt(j) == 'P'){
                    p_pos.add(new int[]{i,j});
                }
                grid[i][j] = place[i].charAt(j);
            }
        }
        for(int i = 0; i < p_pos.size(); i++){
            int[] pos = p_pos.get(i);
            boolean bool = bfs(new int[]{pos[0], pos[1], 0});
            if(!bool) return 0;
        }
        return 1;
    }
    
    public boolean bfs(int[] arr){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(arr);
        boolean[][] visited = new boolean[5][5];
        visited[arr[0]][arr[1]] = true;
        while(!queue.isEmpty()){
            int[] polled = queue.poll();
            int polledX = polled[0];
            int polledY = polled[1];
            int count = polled[2];
            if(count == 2) continue;
            for(int i = 0; i < 4; i++){
                int nx = dx[i]+polledX;
                int ny = dy[i]+polledY;
                if(nx >= 0 && ny >= 0 && nx < 5 && ny < 5){
                    if(!visited[nx][ny]){
                        if(grid[polledX][polledY] == 'P' && grid[nx][ny] == 'P') return false;
                        if(grid[polledX][polledY] == 'O' && grid[nx][ny] == 'P') return false;
                        // if(grid[polledX][polledY] == 'X' && grid[nx][ny] == 'P')
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny, count+1});
                    }
                }
            }
        }
        return true;
    }
}