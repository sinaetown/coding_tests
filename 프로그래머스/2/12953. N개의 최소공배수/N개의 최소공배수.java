class Solution {
    public int solution(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = 1;
            while (true) {
                if (arr[i] * j % arr[i - 1] == 0) {
                    arr[i] = arr[i] * j;
                    break;
                } else {
                    j++;
                }
            }
        }
        return arr[arr.length-1];
    }
}