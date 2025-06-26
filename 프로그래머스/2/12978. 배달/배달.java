import java.util.*;

class Solution {
    public static int[] dist;
    public static boolean[] visited;
    public static List<List<int[]>> list = new ArrayList<>();
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        for(int i = 0; i < N+1; i++) list.add(new ArrayList<>());
        build(N, road, K);
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        visited = new boolean[N+1];
        answer = dijstra(1,K);
        return answer;
    }
    
    public void build(int N, int[][] road, int K){
        for(int i = 0; i < road.length; i++){
            int start = road[i][0];
            int end = road[i][1];
            int weight = road[i][2];
            list.get(start).add(new int[]{end, weight});
            list.get(end).add(new int[]{start, weight});
        }
    }
    
    public int dijstra(int start, int K){
        int answer = 0;
        // int[] {노드, 거리};
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
           @Override
            public int compare(int[] o1, int[] o2){
                return o1[1]-o2[1];
            }
        });
        
        pq.add(new int[]{start, 0});
        dist[start] = 0;
        
        while(!pq.isEmpty()){
            int[] polled = pq.poll();
            int num = polled[0];
            int weight = polled[1];
            if(!visited[num]){
                visited[num] = true;
                for(int i = 0; i < list.get(num).size(); i++){
                if(dist[list.get(num).get(i)[0]] > dist[num] + list.get(num).get(i)[1]){
                    dist[list.get(num).get(i)[0]] = dist[num] + list.get(num).get(i)[1];
                    pq.add(new int[]{list.get(num).get(i)[0], dist[list.get(num).get(i)[0]]});
                    }
                }
            }
        }
        System.out.println(Arrays.toString(dist));
        for(int i = 0; i < dist.length; i++){
            if(i == 0) continue;
            if(K >= dist[i]) answer++;
        }
        return answer;
    }
}