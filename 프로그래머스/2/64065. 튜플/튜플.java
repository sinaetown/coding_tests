import java.util.*;

class Solution {
    public static List<String> tuples = new ArrayList<>();
    public int[] solution(String s) {
        build(s);
        tuples.sort(new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return s1.length() - s2.length();
            }
        });
        int index = 0;
        List<Integer> answer = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < tuples.size(); i++){
            String indiv = tuples.get(i);
            indiv = indiv.substring(1, indiv.length()-1);
            String[] split = indiv.split(",");
            for(int j = 0; j < split.length; j++){
                int num = Integer.parseInt(split[j]);
                if(!set.contains(num)){
                    set.add(num);
                    answer.add(num);
                }
            }
        }
        int[] res = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++){
            res[index++] = answer.get(i);
        }
        return res;
    }
    
    public void build(String s){
        s = s.substring(1, s.length()-1);
        //튜플 하나씩 꺼내기
        boolean isInside = false;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '{'){
                isInside = true;
            }
            else if(s.charAt(i) == '}'){
                isInside = false;
                sb.append('}');
                tuples.add(sb.toString());
                sb = new StringBuilder();
            }
            if(isInside){
                sb.append(s.charAt(i));
            }
        }
    }
}