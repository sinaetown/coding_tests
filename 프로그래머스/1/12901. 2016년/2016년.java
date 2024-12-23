class Solution {
    public static String solution(int a, int b) {
        String answer = "";
        int days = 0;
        for (int i = 1; i < a; i++) {
            if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                days += 31;
            } else if (i == 2) days += 29;
            else days += 30;
        }
        days += b;
        int whatDay = days % 7;
        if (whatDay == 1) return "FRI";
        else if (whatDay == 2) return "SAT";
        else if (whatDay == 3) return "SUN";
        else if (whatDay == 4) return "MON";
        else if (whatDay == 5) return "TUE";
        else if (whatDay == 6) return "WED";
        else if (whatDay == 0) return "THU";
        return answer;
    }
}