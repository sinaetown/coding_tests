import java.util.HashMap;
import java.util.Map;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        int index = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        for (int j = 0; j < photo.length; j++) {
            int sum = 0;
            for (int k = 0; k < photo[j].length; k++) {
                if (map.containsKey(photo[j][k])) sum += map.get(photo[j][k]);
            }
            answer[index++] = sum;
        }
        return answer;
    }
}