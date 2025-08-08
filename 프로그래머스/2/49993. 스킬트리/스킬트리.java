import java.util.*;

class Solution {
    public int index = 0;
    public Queue<Character> queue;
    public Set<Character> set = new HashSet<>();
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(char c : skill.toCharArray()) set.add(c);
        for(String s : skill_trees){
            queue = new ArrayDeque<>();
            for(char c : s.toCharArray()){
                queue.add(c);
            }
            index = 0;
            if(chk(skill)) answer++;
        }
        return answer;
    }
    
    public boolean chk(String skill){
        while(!queue.isEmpty()){
            char polled = queue.poll();
            if((polled != skill.charAt(index))){
                if(set.contains(polled)){ //순서가 어긋남
                    return false;
                }
            //아예 가지고 있지도 않음 -> 무시해도 됨
            }
            else if((polled == skill.charAt(index)) && set.contains(polled)){ //일치함
                index++; 
            }
            if(index >= skill.length()-1) break;
        }
        return true;
    }
}