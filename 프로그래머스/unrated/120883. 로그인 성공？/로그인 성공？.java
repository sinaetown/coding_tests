import java.util.*;

class Solution {
    public String solution(String[] id_pw, String[][] db) {
        Map<String, String> users = new HashMap<>();
        for (int i = 0; i < db.length; i++) {
            users.put(db[i][0], db[i][1]);
        }
        // System.out.println(users); //map print out

        String answer="fail";
        for(String id : users.keySet()){
            if(id.equals(id_pw[0])){
                if(users.get(id).equals(id_pw[1])){
                    answer = "login";
                    break;
                }
                else{
                    answer = "wrong pw";
                    break;
                }
            }
        }
        return answer;
    }
}