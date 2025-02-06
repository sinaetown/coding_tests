class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int len = number.length() - k;
        int start = 0;
        while (start < number.length() && sb.length() != len) {
            int leftNum = k + sb.length() + 1;
            int max = 0;
            for (int j = start; j < leftNum; j++) {
                if (max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';
                    start = j + 1;
                }
            }
            sb.append(Integer.toString(max));
        }
        return sb.toString();
    }
}