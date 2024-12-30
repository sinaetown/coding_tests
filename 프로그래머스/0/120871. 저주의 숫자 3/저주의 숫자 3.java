import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int updated = 0;
        List<Character> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            while (updated % 3 == 0 || list.contains('3')) {
                if (updated % 3 == 0) {
                    updated++;
                } else if (list.contains('3')) {
                    updated++;
                }
                list.clear();

                for (int a = 0; a < Integer.toString(updated).length(); a++) {
                    list.add(Integer.toString(updated).charAt(a));
                }
            }
            answer = updated;
            updated++;
            list.clear();
            for (int a = 0; a < Integer.toString(updated).length(); a++) {
                list.add(Integer.toString(updated).charAt(a));
            }
        }
        return answer;
    }
}