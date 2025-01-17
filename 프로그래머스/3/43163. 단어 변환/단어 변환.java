class Solution {
     int answer = 0;
     boolean[] visited;

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        return answer;
    }

    public void dfs(String begin, String target, String[] words, int cnt) {
        if (begin.equals(target)) {
            answer = cnt;
            return;
        }
        for (int w = 0; w < words.length; w++) {
            if (visited[w]) continue;
            if (changeable(begin, words[w])) {
                visited[w] = true;
                dfs(words[w], target, words, cnt + 1);
                visited[w] = false;
            }
        }
    }

    public boolean changeable(String s1, String s2) {
        int answer = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                answer++;
            }
        }
        if (answer == 1) return true;
        return false;
    }
}