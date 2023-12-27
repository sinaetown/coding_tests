import java.util.*;

class Solution {
    public String solution(String s, int n) {
        String answer ="";
        String[] splitted = s.split("");
        List<Character> slid = new ArrayList<>();
        for (String ll : splitted) {
            int chk = (int) ll.charAt(0) + n;
            char converted = ' ';
            if (ll.charAt(0) >= 'a' && ll.charAt(0) <= 'z') {
                if (chk > 'z') {
                    converted = (char) (ll.charAt(0) + n - 26);
                } else {
                    converted = (char) (ll.charAt(0) + n);
                }
            } else if (ll.charAt(0) >= 'A' && ll.charAt(0) <= 'Z') {
                if (chk > 'Z') {
                    converted = (char) (ll.charAt(0) + n - 26);
                } else {
                    converted = (char) (ll.charAt(0) + n);
                }
            }
            slid.add(converted);
        }
        for (Character ss : slid) {
            answer += ss;
        }
        return answer;
    }
}