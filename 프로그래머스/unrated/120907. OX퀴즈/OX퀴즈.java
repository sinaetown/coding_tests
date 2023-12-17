class Solution {
    public String[] solution(String[] quiz) {
       String[] answer = new String[quiz.length];
        int ind = 0;
        String[] splitted;
        for(String s : quiz){
            splitted = s.split(" ");
            if(splitted[1].equals("+")){
                if(Integer.parseInt(splitted[4])==Integer.parseInt(splitted[0])+Integer.parseInt(splitted[2])){
                    answer[ind++] = "O";
                }
                else{
                    answer[ind++] = "X";
                }
            }
            else{
                if(Integer.parseInt(splitted[4])==Integer.parseInt(splitted[0])-Integer.parseInt(splitted[2])){
                    answer[ind++] = "O";
                }
                else{
                    answer[ind++] = "X";
                }
            }
        }
        return answer;
    }
}