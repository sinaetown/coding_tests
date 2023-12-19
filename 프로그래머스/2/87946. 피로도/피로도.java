class Solution {
    static int answer;

    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        recur(dungeons, visited, k, 0, 0);
        System.out.println(answer);
        return answer;
    }

    static void recur(int[][] dungeons, boolean[] visited, int k, int count, int p) {
        if (count == dungeons.length) {
            if (answer < p) {
                answer = p;
            }
            return;
        } else {
            for (int i = 0; i < dungeons.length; i++) {
                 if (!visited[i] && (dungeons[i][0] <= k) && (k>=0)){
                    visited[i] = true;
                    k = k - dungeons[i][1];
                    p++;
                    recur(dungeons, visited, k, count + 1, p);
                    k = k + dungeons[i][1];
                    p--;
                    visited[i] = false;
                }
                recur(dungeons, visited, k, count + 1, p);
            }
        }
    }
}