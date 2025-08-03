import java.util.*;

class Solution {
    
    public int[] parent;
    
    public int find(int a){ //부모 찾기
        if(parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }
    
    public void union(int a, int b){ //연결하기
        a = find(a); //a 부모 찾기
        b = find(b); //b 부모 찾기
        if(a!=b) parent[b]=a;
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        for(int i = 0; i < n; i++) parent[i] = i;
        Arrays.sort(costs, (o1, o2)->o1[2]-o2[2]); //간선들의 오름차순 정렬
        
        for(int i = 0; i < costs.length; i++){
            if(find(costs[i][0]) != find(costs[i][1])){ //사이클을 만들지 않는다면 (부모가 같지 않다면)
                union(costs[i][0], costs[i][1]); //연결하기
                answer += costs[i][2];
            }
        }
        return answer;
    }
}