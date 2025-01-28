class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        int number = 0;
        int length = 0;
        int index = p - 1;
        StringBuilder sb = new StringBuilder();
        while (answer.length() < t) {
            String converted = convert(n, number);
            sb.append(converted);
            length = sb.length();
            if (length > index) {
                answer += sb.charAt(index);
                index += m;
            }
            number++;
        }
        return answer;
    }
    
    public String convert(int n, int number) {
        String answer = "";
        if (number == 0) return "0";
        while (number != 0) {
            int over = number % n;
            if (n >= 11) {
                if (over >= 10) {
                    if (over == 10) answer = 'A' + answer;
                    if (over == 11) answer = 'B' + answer;
                    if (over == 12) answer = 'C' + answer;
                    if (over == 13) answer = 'D' + answer;
                    if (over == 14) answer = 'E' + answer;
                    if (over == 15) answer = 'F' + answer;
                } else {
                    answer = Integer.toString(over) + answer;
                }
            } else {
                answer = Integer.toString(over) + answer;
            }
            number /= n;
        }
        return answer;
    }
}