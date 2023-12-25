class Solution {
    public String solution(String my_string, int[][] queries) {
        String reversed = "";
        String answer = "";
        String changed = my_string;
        for (int i = 0; i < queries.length; i++) {
            for (int j = queries[i][1]; j >= queries[i][0]; j--) {
                reversed += changed.charAt(j);
            }
            changed = changed.substring(0, queries[i][0]) + reversed + changed.substring(queries[i][1]+1);
            reversed = "";
        }
        answer=changed;
        return answer;
    }
}