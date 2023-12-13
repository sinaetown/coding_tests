import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Set<String> chkSet = new HashSet<>();
        for (int i = 0; i < phone_book.length; i++) {
            chkSet.add(phone_book[i]);
        }
        for (String s : chkSet) {
           for(int i = 0; i < s.length(); i++){
               if (chkSet.contains(s.substring(0, i))) {
                   answer = false;
               }
           }
        }
        return answer;
    }
}