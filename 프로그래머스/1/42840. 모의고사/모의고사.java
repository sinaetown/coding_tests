import java.util.*;
class Solution {
    public int[] solution(int[] answers)  {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> afterMax = new ArrayList<>();
        int ind = 0;
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int firstCnt = 0;
        int secondCnt = 0;
        int thirdCnt = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == first[i % 5]) {
                firstCnt += 1;
            }
            if (answers[i] == second[i % 8]) {
                secondCnt += 1;
            }
            if (answers[i] == third[i % 10]) {
                thirdCnt += 1;
            }
        }
        list.add(firstCnt);
        list.add(secondCnt);
        list.add(thirdCnt);
        int max = -1;
        for (int j = 0; j < list.size(); j++) {
            if (max < list.get(j) && list.get(j) != 0) {
                max = list.get(j);
            }
        }
        for (int a = 0; a < list.size(); a++) {
            if (list.get(a) == max) {
                afterMax.add(a + 1);
            }
        }
        int[] answer = new int[afterMax.size()];
        for (int b = 0; b < afterMax.size(); b++) {
            answer[ind++] = afterMax.get(b);
        }
        return answer;
    }
}