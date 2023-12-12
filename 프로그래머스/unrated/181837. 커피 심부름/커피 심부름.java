class Solution {
    public int solution(String[] order) {
        int answer = 0;
        for(String s : order){
            if(s.contains("americano") || s.contains("anything")){
                answer+=4500;
            }
            else if(s.contains("cafelatte")){
                answer+=5000;
            }
        }
        return answer;
    }
}