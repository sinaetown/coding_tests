class Solution {
    public String solution(String my_string) {
        String answer = "";
        char[] c = new char[my_string.length()];
        for(int i = my_string.length()-1; i >= 0; i--){
              c[i] = my_string.charAt(i);
              answer+=c[i];
        }
    
        return answer;
    }
}