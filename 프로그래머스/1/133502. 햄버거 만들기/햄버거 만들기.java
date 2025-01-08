import java.util.*;

class Solution {
    public int solution(int[] ingredient){
        int answer = 0;
        List<Integer> hamburger = new ArrayList<>();
        for (int i = 0; i < ingredient.length; i++) {
            hamburger.add(ingredient[i]);
            if (hamburger.size() >= 4) {
                int index = hamburger.size()-1;
                if (hamburger.get(index) == 1 &&
                        hamburger.get(index - 1) == 3 &&
                        hamburger.get(index - 2) == 2 &&
                        hamburger.get(index - 3) == 1) {
                    hamburger.remove(index);
                    hamburger.remove(index - 1);
                    hamburger.remove(index - 2);
                    hamburger.remove(index - 3);
                    answer++;
                }
            }
        }
        return answer;
    }
}