class Solution {
    public String solution(String n_str) {
       String answer = "";
//        "854020"
//        "0010"
        int stop = 0;
        if (n_str.charAt(0) == '0') {
            for (int i = 1; i < n_str.length(); i++) {
                if (n_str.charAt(i) != '0') {
                    stop = i;
                    break;
                }
            }
        } else {
            answer = n_str;
            return answer;
        }

        if (stop >0) {
            answer = n_str.substring(stop);
            return answer;
        }
        // else if(stop==1){
        //     answer= n_str;
        //     return answer;
        // }
        return answer;
}
}