import java.util.*;

class Solution {
   String word;
    String[] alpha = {"A", "E", "I", "O", "U"};
    List<String> list = new ArrayList<>();

    public int solution(String word) {
        this.word = word;
        perm("", 0);
        return list.indexOf(word);
    }

    public  void perm(String str, int depth) {
        list.add(str);
        if (depth == 5) return;
        for (int i = 0; i < alpha.length; i++) perm(str + alpha[i], depth + 1);
    }
}