class Solution {
     int[][] keypad = {{10, 7, 4, 1}, {0, 8, 5, 2}, {11, 9, 6, 3}};

    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int[] left = {0, 0};
        int[] right = {2, 0};
        int leftCnt = 0;
        int rightCnt = 0;
        for (int i : numbers) {
            if (i == 1 || i == 4 || i == 7) {
                left = find(i);
                sb.append("L");
            } else if (i == 3 || i == 6 || i == 9) {
                right = find(i);
                sb.append("R");
            } else {
                int fromRight = Math.abs(find(i)[0] - right[0]) + Math.abs(find(i)[1] - right[1]);
                int fromLeft = Math.abs(find(i)[0] - left[0]) + Math.abs(find(i)[1] - left[1]);
                if (fromLeft < fromRight) {
                    left = find(i);
                    sb.append("L");
                } else if (fromRight < fromLeft) {
                    right = find(i);
                    sb.append("R");
                } else {
                    if (hand.equals("right")) {
                        right = find(i);
                        sb.append("R");
                    } else {
                        left = find(i);
                        sb.append("L");
                    }
                }
            }
        }
        return sb.toString();
    }
    
    public int[] find(int i) {
        for (int a = 0; a < keypad.length; a++) {
            for (int b = 0; b < keypad[0].length; b++) {
                if (keypad[a][b] == i) return new int[]{a, b};
            }
        }
        return null;
    }
}