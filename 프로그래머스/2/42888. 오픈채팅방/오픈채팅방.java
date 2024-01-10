import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        String[] answer;
        Map<String, String> map = new HashMap<>();
        int ind = 0;
        int count = 0;
        for (String r : record) {
            StringTokenizer st = new StringTokenizer(r);
            String cmd = st.nextToken();
            if (cmd.equals("Enter") || cmd.equals("Change")) {
                String uID = st.nextToken();
                String nickname = st.nextToken();
                map.put(uID, nickname); //마지막 닉네임 세팅
            }
            if (cmd.equals("Enter") || cmd.equals("Leave")) {
                count++;
            }
        }
        answer = new String[count];
        for (String r : record) {
            StringTokenizer st = new StringTokenizer(r);
            String cmd = st.nextToken();
            String uID = st.nextToken();
            if (cmd.equals("Enter")) {
                answer[ind++] = map.get(uID) + "님이 들어왔습니다.";
            } else if (cmd.equals("Leave")) {
                answer[ind++] = map.get(uID) + "님이 나갔습니다.";
            }
        }
        return answer;
    }
}