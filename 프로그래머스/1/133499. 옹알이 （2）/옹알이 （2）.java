import java.util.*;

class Solution {
    public int solution(String[] babbling){
        int answer = 0;
        boolean flag = false;
        String[] speaks = {"aya", "ye", "woo", "ma"};
        List<Boolean> list = new ArrayList<>();
        for (int i = 0; i < babbling.length; i++) {
            for (int j = 0; j < babbling[i].length(); j++) {
                if (babbling[i].charAt(j) == 'a') {
                    if (j + 6 <= babbling[i].length() && babbling[i].substring(j, j + 6).equals("ayaaya")) {
                        flag = false;
                        break;
                    } else if (j + 3 <= babbling[i].length() && babbling[i].substring(j, j + 3).equals("aya")) {
                        flag = true;
                        j += 2;
                    } else {
                        flag = false;
                        break;
                    }
                } else if (babbling[i].charAt(j) == 'y') {
                    if (j + 4 <= babbling[i].length() && babbling[i].substring(j, j + 4).equals("yeye")) {
                        flag = false;
                        break;
                    } else if (j + 2 <= babbling[i].length() && babbling[i].substring(j, j + 2).equals("ye")) {
                        flag = true;
                        j += 1;
                    } else {
                        flag = false;
                        break;
                    }
                } else if (babbling[i].charAt(j) == 'w') {
                    if (j + 6 <= babbling[i].length() && babbling[i].substring(j, j + 6).equals("woowoo")) {
                        flag = false;
                        break;
                    } else if (j + 3 <= babbling[i].length() && babbling[i].substring(j, j + 3).equals("woo")) {
                        flag = true;
                        j += 2;
                    } else {
                        flag = false;
                        break;
                    }
                } else if (babbling[i].charAt(j) == 'm') {
                    if (j + 4 <= babbling[i].length() && babbling[i].substring(j, j + 4).equals("mama")) {
                        flag = false;
                        break;
                    } else if (j + 2 <= babbling[i].length() && babbling[i].substring(j, j + 2).equals("ma")) {
                        flag = true;
                        j += 1;
                    } else {
                        flag = false;
                        break;
                    }
                } else {
                    flag = false;
                    break;
                }
            }
            list.add(flag);
            flag = false;
        }
        for (int q = 0; q < list.size(); q++) {
            if (list.get(q)) answer++;
        }
        return answer;
    }
}