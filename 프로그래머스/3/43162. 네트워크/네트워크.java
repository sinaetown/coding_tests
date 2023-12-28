class Solution {
     static boolean[] visited;
    static int[][] static_computers;
    static int count = 0;
    
    public int solution(int n, int[][] computers) {
        static_computers = computers;
        visited = new boolean[n];
        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[i].length; j++) {
                if (!visited[i] && computers[i][j] == 1) {
                    dfs(j);
                    count++;
                }
            }
        }
        return count;
    }

    static void dfs(int start) {
        visited[start] = true;
        for (int i = 0; i < static_computers[start].length; i++) {
            if (!visited[i] && static_computers[start][i] == 1) {
                dfs(i);
            }
        }
    }
    }