import java.util.*;

class Solution {
    Map<Character, Integer> map = new HashMap<>();

    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int ind = 0;
        int[] scale = {3, 2, 1, 0, 1, 2, 3};
        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);
        for (String s : survey) {
            if (choices[ind] - 1 == 3) {
                ind++;
                continue;
            } 
            else if (choices[ind] - 1 <= 2) {
                updateMap(s.charAt(0), scale[choices[ind] - 1]);
            } else if (choices[ind] - 1 >= 4) {
                updateMap(s.charAt(1), scale[choices[ind] - 1]);
            }
            ind++;
        }
        StringBuilder sb = new StringBuilder();
        Character first = ' ', second = ' ', third = ' ', fourth = ' ';
        if (map.get('T') <= map.get('R')) {
            first = 'R';
        } else first = 'T';
        if (map.get('F') <= map.get('C')) {
            second = 'C';
        } else second = 'F';
        if (map.get('M') <= map.get('J')) {
            third = 'J';
        } else third = 'M';
        if (map.get('N') <= map.get('A')) {
            fourth = 'A';
        } else fourth = 'N';
        sb.append(Character.toString(first));
        sb.append(Character.toString(second));
        sb.append(Character.toString(third));
        sb.append(Character.toString(fourth));
        return sb.toString();
    }
    
    public void updateMap(Character c, int i) {
        map.put(c, map.get(c) + i);
    }
}