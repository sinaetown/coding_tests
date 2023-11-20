class Solution {
    public String solution(String cipher, int code) {
        String answer = "";
        int len = cipher.length();
        for(int i = code; i <= len; i+=code){
            answer+=cipher.charAt(i-1);
        }
        return answer;
    }
}