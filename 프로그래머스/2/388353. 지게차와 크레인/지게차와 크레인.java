import java.util.*;
class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] map;
    public int solution(String[] storage, String[] requests) {
        build(storage);
        for(String request : requests){
            if(request.length() == 2) crane(request.charAt(0));
            else forkLift(request.charAt(0));
        }
        return count();
    }
    
    public int count(){
        int answer = 0;
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                if(map[i][j] != '.') answer++;
            }
        }
        return answer;
    }
    public void forkLift(char request){
        List<int[]> list = new ArrayList<>();
        
        for(int i = 0; i < map.length; i++){ //일치하는 위치 찾기
            for(int j = 0; j < map[i].length; j++){
                if(map[i][j] == request){
                    list.add(new int[]{i,j});
                }
            }
        }
        
        boolean[] visited = new boolean[list.size()]; //접근 가능한 위치만 따로 visited 표시 (없어져야할 좌표의 위치 기록해두기)
        for(int i = 0; i < list.size(); i++){
            if(isPossible(list.get(i), request)){
                visited[i] = true;
            }
        }
        
        for(int i = 0; i < visited.length; i++){ //visited 표시가 된 위치의 값만 .로 바꾸기
            if(visited[i]){
                int a = list.get(i)[0];
                int b = list.get(i)[1];
                map[a][b] = '.';
            }
        }
    }
    
    public boolean isPossible(int[] position, char request){ //주어진 pos에서 바깥까지 도달할 수 있는지 확인
        boolean[][] visited = new boolean[map.length][map[0].length];
        Queue<int[]> queue = new ArrayDeque<>();
        
        queue.add(position);
        visited[position[0]][position[1]] = true;
        
        while(!queue.isEmpty()){
            int[] polled = queue.poll();
            if(polled[0] == 0  //바깥도달 확인 로직!
               || polled[1] == 0 
              || polled[0] == map.length-1 
               || polled[1] == map[0].length-1) return true;
            
            for(int i = 0; i < 4; i++){
                int nx = polled[0] + dx[i];
                int ny = polled[1] + dy[i];
                
                if(nx >= 0 && ny >= 0
                  && nx < map.length && ny < map[0].length){
                    if(!visited[nx][ny] && map[nx][ny] == '.'){
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx,ny});
                    }
                }
            }
        }
        return false;
    }
    
    public void crane(char request){
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                if(map[i][j] == request){
                    map[i][j] = '.';
                }
            }
        }
    }
    
    
    public void build(String[] storage){
        map = new char[storage.length][storage[0].length()];
        for(int i = 0; i < storage.length; i++){
            for(int j = 0; j < storage[0].length(); j++){
                map[i][j] = storage[i].charAt(j);
            }
        }
    }
}

