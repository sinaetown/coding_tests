import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> cache = new ArrayList<>();
        if (cacheSize == 0) return cities.length * 5;
        for (String c : cities) {
            String city = c.toLowerCase();
            if (!cache.contains(city)) { //miss
                if (cache.size() == cacheSize) {
                    cache.remove(0);
                }
                answer += 5;
                cache.add(city);
            } else { //hit
                answer += 1;
                cache.remove(city);
                cache.add(city);
            }
        }
        return answer;
    }
}