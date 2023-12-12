class Solution {
    public String solution(String[] str_list, String ex) {
        String answer = "";
        for(String i : str_list){
            if(!(i.contains(ex))){
                answer+=i;
            }
        }
        return answer;
    }
}