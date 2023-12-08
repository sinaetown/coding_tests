class Solution {
    public int solution(String my_string, String is_prefix) {
        int answer = 0;
       
        if(my_string.length() >= is_prefix.length()){
            String subs = my_string.substring(0,(is_prefix.length()));
            if(is_prefix.equals(subs)){
                answer = 1;
            }
             System.out.print(subs);
        }
       
        return answer;
    }
}