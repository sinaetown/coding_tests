import java.util.*;

class Solution {
    Map<String, Integer> map;
    int max = 0;
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        List<String> ans = new ArrayList<>();
        for(int c:course){
            map = new HashMap<>();
            max = 0;
            
            for(String order : orders){
                char[] strs = order.toCharArray();
                Arrays.sort(strs);
                order = new String(strs);
                dfs(order, "", -1, c, 0);
            }
            
            for(String key : map.keySet()){
                int val = map.get(key);
                if(val > 1 && max == val){
                    ans.add(key);
                }
            }
        }
        Collections.sort(ans);
        answer = ans.toArray(new String[ans.size()]);
        return answer;
    }
    
    public void dfs(String order, String key, int index, int end, int depth){
        if(depth == end){
            map.put(key, map.getOrDefault(key, 0)+1);
            max = Math.max(max, map.get(key));
        }
        
        for(int i = index + 1; i < order.length(); i++){
            dfs(order, key+order.charAt(i), i, end, depth+1);
        }
    
    }
}