import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        List<Integer> originLost = new ArrayList<>();
        List<Integer> originReserve = new ArrayList<>();
        List<Integer> lostList = new ArrayList<>();
        List<Integer> reserveList = new ArrayList<>();

        boolean[] dupLost = new boolean[lost.length];
        boolean[] dupReserve = new boolean[reserve.length];

        for (int a = 0; a < lost.length; a++) originLost.add(lost[a]);
        for (int b = 0; b < reserve.length; b++) originReserve.add(reserve[b]);

        for (int c = 0; c < originLost.size(); c++) {
            if (originReserve.contains(originLost.get(c))) {
                dupLost[originLost.indexOf(originLost.get(c))] = true;
                dupReserve[originReserve.indexOf(originLost.get(c))] = true;
            }
        }

        for(int x = 0; x < originLost.size(); x++){
            if(!dupLost[x]) lostList.add(originLost.get(x));
        }
        for(int y = 0; y< originReserve.size(); y++){
            if(!dupReserve[y]) reserveList.add(originReserve.get(y));
        }
        lostList.sort(null);
        reserveList.sort(null);

        boolean[] reserveChk = new boolean[reserveList.size()];
        boolean[] lostChk = new boolean[lostList.size()];

        for (int l = 0; l < lostList.size(); l++) {
            if (reserveList.contains(lostList.get(l) - 1) && !reserveChk[reserveList.indexOf(lostList.get(l) - 1)]) {
                reserveChk[reserveList.indexOf(lostList.get(l) - 1)] = true;
                lostChk[l] = true;
            } else if (reserveList.contains(lostList.get(l) + 1) && !reserveChk[reserveList.indexOf(lostList.get(l) + 1)]) {
                reserveChk[reserveList.indexOf(lostList.get(l) + 1)] = true;
                lostChk[l] = true;
            }
        }

        for (int q = 1; q <= n; q++) {
            if (lostList.contains(q)) {
                int ind = lostList.indexOf(q);
                if (lostChk[ind]) answer++;
            } else answer++;
        }
        return answer;
    }
}