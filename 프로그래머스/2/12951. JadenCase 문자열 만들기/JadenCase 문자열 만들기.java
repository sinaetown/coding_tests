import java.util.*;

class Solution {
    public String solution(String s) {
        String[] splitted = s.split(" ");
        String converted = "";
        String result = "";
        List<String> l = new ArrayList<>();
        for (String ss : splitted) {
            for (int i = 0; i < ss.length(); i++) {
                if (i == 0) {
                    converted += Character.toUpperCase(ss.charAt(i));
                } else {
                    converted += Character.toLowerCase(ss.charAt(i));
                }
            }
            if (!converted.equals("")) {
                l.add(converted);
            }
            converted = "";
        }
        int p = 0;
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == ' ') {
                result += ' ';
            } else {
                result += l.get(p);
                j += l.get(p).length() - 1;
                p++;
            }
        }
        return result;
    }
}