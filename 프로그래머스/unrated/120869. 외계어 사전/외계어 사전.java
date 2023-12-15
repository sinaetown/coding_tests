import java.util.*;

class Solution {
    static String[] arr;
    static boolean[] visited;

    static String[] given;
    static List<String> strList = new ArrayList<>();
    ;
    
    public int solution(String[] spell, String[] dic) {
        List<String> dictionary = new ArrayList<>(Arrays.asList(dic));
        given = spell;
        int answer = 0;
        arr = new String[spell.length];
        visited = new boolean[spell.length];
        recur(0);
        for(String w : strList){
            if(dictionary.contains(w)){
                answer = 1;
                break;
            }
            else{
                answer = 2;
            }
        }
        return answer;
}
    public static void recur(int r) {
        String res = "";
        if (r == given.length) {
            for (String s : arr) {
                res += s;
            }
            strList.add(res);
            res = "";
        } else {
            for (int i = 0; i < given.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    arr[r] = given[i];
                    recur(r + 1);
                    visited[i] = false;
                }
            }
        }
    }
}