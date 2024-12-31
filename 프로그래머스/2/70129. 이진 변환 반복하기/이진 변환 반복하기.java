class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int num = 0;
        int zeros = 0;
        int count = 0;
        boolean flag = true;
        while (!s.equals("1")) {
            count++;
            String updated = "";
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != '0') {
                    updated += s.charAt(i);
                } else {
                    zeros++;
                }
            }
            s = Integer.toBinaryString(updated.length());
        }
        answer[0] = count;
        answer[1] = zeros;
        return answer;
    }
}