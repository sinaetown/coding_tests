import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        Map<Character, Integer> xMap = new HashMap<>();
        Map<Character, Integer> yMap = new HashMap<>();
        List<Character> common = new ArrayList<>();
        for (int x = 0; x < X.length(); x++) {
            if (!xMap.containsKey(X.charAt(x))) xMap.put(X.charAt(x), 1);
            else xMap.put(X.charAt(x), xMap.get(X.charAt(x)) + 1);
        }
        for (int y = 0; y < Y.length(); y++) {
            if (!yMap.containsKey(Y.charAt(y))) yMap.put(Y.charAt(y), 1);
            else yMap.put(Y.charAt(y), yMap.get(Y.charAt(y)) + 1);
        }
        Iterator<Character> xIterator = xMap.keySet().iterator();
        while (xIterator.hasNext()) {
            Character keyX = xIterator.next();
            if (yMap.containsKey(keyX)) {
                int repeat = 0;
                if (yMap.get(keyX) < xMap.get(keyX)) {
                    repeat = yMap.get(keyX);
                } else {
                    repeat = xMap.get(keyX);
                }
                for (int r = 0; r < repeat; r++) {
                    common.add(keyX);
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        if (common.size() == 0) return "-1";
        else {
            common.sort(Comparator.reverseOrder());
            if (common.get(0) == '0') {
                return "0";
            } else {
                for (int c = 0; c < common.size(); c++) {
                    sb.append(common.get(c));
                }
            }
        }
        return sb.toString();
    }
}