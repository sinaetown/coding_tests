class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int answerInd = 0;

        for (int t = 0; t < targets.length; t++) {
            int cnt = 0;
            for (int k = 0; k < targets[t].length(); k++) {
                Character c = targets[t].charAt(k);
                int min = 101;
                for (int q = 0; q < keymap.length; q++) {
                    for (int p = 0; p < keymap[q].length(); p++) {
                        if (keymap[q].charAt(p) == c) {
                            if (min > p + 1) min = p + 1;
                        }
                    }
                }
                if (min == 101) {
                    cnt = -1;
                    break;
                }
                else cnt += min;
            }
            answer[answerInd++] = cnt;
        }
        return answer;
    }
}