import java.util.*;

class Solution {
    String[] alpha = {"A", "E", "I", "O", "U"};
    List<String> list = new ArrayList<>();
    
    public int solution(String word) {
        int answer = 0;
        permutation(0,"",word);
        return list.indexOf(word);
    }
    
    public void permutation(int depth, String res, String word){
        list.add(res);
        if(depth == 5) return;
        for(int i = 0; i < 5; i++) permutation(depth+1, res+alpha[i] ,word);
    }
}