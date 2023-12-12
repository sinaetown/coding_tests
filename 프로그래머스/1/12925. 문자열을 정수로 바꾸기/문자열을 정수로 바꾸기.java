class Solution {
    public int solution(String s) {
        int answer = 0;
        if(s.charAt(0)=='-'){
            String ss = s.substring(1);
            answer=Integer.parseInt(ss)*(-1);
        }
        else{
            answer=Integer.parseInt(s);
        }
        return answer;
    }
}