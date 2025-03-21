import java.util.*;

class Solution {
     List<Integer>[] edges;
    
    public int solution(int n, int[][] wires) {
        int answer = -1;
        // select edge to exclude
        // build tree
        edges = new List[n+1];
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < wires.length; i++){
            for(int j = 1; j <= n; j++) edges[j] = new ArrayList<>();
            buildTree(i, wires);
            boolean[] visited = new boolean[n+1];
            int [] arr = (bfs(edges, visited, 1, n));
            if(Math.abs(arr[0]-arr[1]) < min){
                min = Math.abs(arr[0]-arr[1]);
                answer = min;
            }
        }
        return answer;
    }
    
    public int[] bfs(List<Integer>[] edges, boolean[] visited, int start, int total){
        Queue<Integer> queue = new ArrayDeque<>();
        visited[start] = true;
        queue.add(start);
        int cnt = 0;
        while(!queue.isEmpty()){
            int polled = queue.poll();
            cnt++;
            List<Integer> list = edges[polled];
            if(list.size()==0) return new int[]{1, total-1};
            for(int i = 0; i < list.size(); i++){
                if(!visited[list.get(i)]){
                    queue.add(list.get(i));
                    visited[list.get(i)]=true;
                }
            }
        }
        return new int[]{cnt, total-cnt};
    }
    
    public void buildTree(int exclude, int[][] wires){
        for(int i = 0; i < wires.length; i++){
            if(i!=exclude){
                edges[wires[i][0]].add(wires[i][1]);
                edges[wires[i][1]].add(wires[i][0]);
            }
        }
    }
}