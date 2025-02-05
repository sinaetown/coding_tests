class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
            } else {
                String toBinary = Long.toBinaryString(numbers[i]);
                if (toBinary.contains("0")) {
                    int index = toBinary.lastIndexOf("0");
                    toBinary = toBinary.substring(0, index) + "10" + toBinary.substring(index + 2);
                } else {
                    toBinary = "10" + toBinary.substring(1);
                }
                answer[i] = Long.parseLong(toBinary, 2);
            }
        }
        return answer;
    }
}