import java.util.ArrayList;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        int ind = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (k > score.length) {
            for (int a = 0; a < score.length; a++) {
                arrayList.add(score[a]);
                arrayList.sort(null);
                answer[ind++] = arrayList.get(0);
            }
        } else {
            for (int a = 0; a < k; a++) {
                arrayList.add(score[a]);
                arrayList.sort(null);
                answer[ind++] = arrayList.get(0);
            }
            for (int i = k; i < score.length; i++) {
                for (int j = 0; j < arrayList.size(); j++) {
                    if (arrayList.get(j) < score[i]) {
                        arrayList.remove(0);
                        arrayList.add(score[i]);
                        break;
                    }
                }
                arrayList.sort(null);
                answer[ind++] = arrayList.get(0);
            }
        }
        return answer;
    }
}