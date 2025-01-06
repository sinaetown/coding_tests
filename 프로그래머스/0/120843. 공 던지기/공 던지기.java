class Solution {
    public int solution(int[] numbers, int k) {
        int count = 1;
        int track = 1;
        int last = numbers.length;
        while (count < k) {
            track += 2;
            if (track > last) {
                track -= last;
            }
            count++;
        }
        return track;
    }
}