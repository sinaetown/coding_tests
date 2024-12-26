import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        List<String> list = new ArrayList<>();
        char x = s.charAt(0);
        int count = 0, other = 0, tracker = 0;
        int start = 0;
        while (tracker < s.length()) {
            if (s.charAt(tracker) == x) count++;
            else if (s.charAt(tracker) != x) other++;
            if (count == other) {
                list.add(s.substring(start, tracker + 1));
                count = 0;
                other = 0;
                s = s.substring(tracker + 1);
                if(s.length()!=0) x = s.charAt(0);
                else break;
                tracker = 0;
            } else tracker++;
        }
        list.add(s);
        for(int i = 0; i < list.size(); i++){
            if(!list.get(i).equals("")) answer++;
        }
        return answer;
    }
}