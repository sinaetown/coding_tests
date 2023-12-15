import java.util.*;

class Solution {
    public String solution(String polynomial) {
        String answer = "";
        String[] splitted = polynomial.split(" ");
        int sumX = 0;
        int sumN = 0;
        List<String> l = new ArrayList<>();
        for(String s : splitted){
            if(s.contains("x")){
                String i = s.substring(0, s.length()-1);
                l.add(i);
            }
            else if (!s.equals("+")){
                sumN+=Integer.parseInt(s);
            }
        }
//        Calculating x's
        for(String x : l){
            if(!x.equals("")){
                sumX+=Integer.parseInt(x);
            }
            else{
                sumX+=1;
            }
        }
//        System.out.println(sumX);
//        System.out.println(sumN);

        if (sumX == 0) {
            answer = Integer.toString(sumN);
        } else { // x계수가 1 이상일 경우
            if (sumX == 1) { // x계수가 1일 경우
                if (sumN == 0) {
                    answer = "x";
                } else {
                    answer = "x + " + sumN;
                }
            } else { // x계수가 2보다 클 경우
                if (sumN == 0) {
                    answer = sumX + "x";
                } else {
                    answer += sumX + "x + " + sumN;
                }
            }
        }
        return answer;
        }
    
    }