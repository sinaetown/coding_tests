class Solution {
    public int solution(int n) {
        int answer = 0;
        int m = n + 1;
        while (true) {
            String str = Integer.toBinaryString(m);
            if (count(Integer.toBinaryString(n)) == count(str)) {
                return m;
            }
            m++;
        }
    }

    public int count(String str) {
        int cnt = 0;
        for (int s = 0; s < str.length(); s++) {
            if (str.charAt(s) == '1') cnt++;
        }
        return cnt;
    }
}