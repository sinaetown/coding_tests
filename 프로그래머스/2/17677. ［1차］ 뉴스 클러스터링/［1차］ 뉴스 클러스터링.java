import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        List<String> list1 = makeSet(str1);
        List<String> list2 = makeSet(str2);
        Set<String> done = new HashSet<>();
        Collections.sort(list1);
        Collections.sort(list2);
        int intersection = 0;
        for (int i = 0; i < list1.size(); i++) {
            if (!done.contains(list1.get(i))) {
                int count1 = count(list1, list1.get(i));
                int count2 = 0;
                if (list2.contains(list1.get(i))) {
                    count2 = count(list2, list1.get(i));
                }
                intersection += Math.min(count1, count2);
                done.add(list1.get(i));
            }
        }
        int union = list1.size() + list2.size() - intersection;
        if (intersection == 0 && union == 0) return 65536;
        float answer = (float) intersection / union * 65536;
        return (int) answer;
    }

    public List<String> makeSet(String str) {
        List<String> list = new ArrayList<>();
        for (int a = 0; a < str.length() - 1; a++) {
            if (Character.isAlphabetic(str.charAt(a))
                    && Character.isAlphabetic(str.charAt(a + 1))) {
                StringBuilder sb = new StringBuilder();
                sb.append(Character.toLowerCase(str.charAt(a)));
                sb.append(Character.toLowerCase(str.charAt(a + 1)));
                list.add(sb.toString());
            }
        }
        return list;
    }

    public int count(List<String> list, String target) {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(target)) count++;
        }
        return count;
    }
}