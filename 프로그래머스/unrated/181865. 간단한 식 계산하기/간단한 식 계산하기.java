class Solution {
    public int solution(String binomial) {
        int answer = 0;
        String[] splitted = binomial.split(" ");
        System.out.print(splitted[1]);
        if(splitted[1].equals("+")){
            answer = Integer.parseInt(splitted[0]) + Integer.parseInt(splitted[2]);
        }
        else if(splitted[1].equals("-")){
             answer = Integer.parseInt(splitted[0]) - Integer.parseInt(splitted[2]);
        }
        else{
             answer =  Integer.parseInt(splitted[0]) * Integer.parseInt(splitted[2]);
        }
        return answer;
    }
}