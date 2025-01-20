import java.util.*;

class Solution {
     boolean[] visited;
     String[] answer;
     List<String> list;

    public  String[] solution(String[][] tickets) {
        answer = new String[tickets.length + 1];
        visited = new boolean[tickets.length];
        list = new ArrayList<>();
        dfs("ICN", "ICN", 0, tickets);
        Collections.sort(list);
        answer = list.get(0).split(" ");
        return answer;
    }

    public  void dfs(String departure, String route, int cnt, String[][] tickets) {
        if (cnt == tickets.length) {
            list.add(route);
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && departure.equals(tickets[i][0])) {
                visited[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1], cnt + 1, tickets);
                visited[i] = false;
            }
        }
    }
}