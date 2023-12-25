class Solution {
    public long solution(String give) {
        long answer = 0;
        give = give.replace("zero", "zero ");
        give = give.replace("one", "one ");
        give = give.replace("two", "two ");
        give = give.replace("three", "three ");
        give = give.replace("four", "four ");
        give = give.replace("five", "five ");
        give = give.replace("six", "six ");
        give = give.replace("seven", "seven ");
        give = give.replace("eight", "eight ");
        give = give.replace("nine", "nine ");
        String[] s = give.split(" ");
        String str = "";
        for (String a : s) {
            if (a.equals("zero")) {
                str += "0";
            } else if (a.equals("one")) {
                str += "1";
            } else if (a.equals("two")) {
                str += "2";
            } else if (a.equals("three")) {
                str += "3";
            } else if (a.equals("four")) {
                str += "4";
            } else if (a.equals("five")) {
                str += "5";
            } else if (a.equals("six")) {
                str += "6";
            } else if (a.equals("seven")) {
                str += "7";
            } else if (a.equals("eight")) {
                str += "8";
            } else if (a.equals("nine")) {
                str += "9";
            }
        }
        answer=Long.parseLong(str);
        return answer;
    }
}