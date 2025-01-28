class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String[] splitted = convert(n, k).split("0");
        for (String s : splitted) {
            if(s.isBlank()) continue;
            long i = Long.parseLong(s);
            if(isPrime(i)) answer++;
        }
        return answer;
    }

    public boolean isPrime(long i) {
         int cnt = 0;
        if (i == 1) return false;
        for (int a = 1; (long) a * a <= i; a++) {
            if ((long) a * a == i) cnt++;
            else if (i % a == 0) cnt += 2;
            if(cnt>2) return false;
        }
        return true;
    }

    public String convert(int n, int k) {
        String answer = "";
        while (n != 0) {
            String left = Integer.toString(n % k);
            answer = left + answer;
            n /= k;
        }
        return answer;
    }
}