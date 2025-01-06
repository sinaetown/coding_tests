import java.util.*;

class Solution {
    public int solution(int a, int b) {
        List<Integer> list = new ArrayList<>();
        boolean flag = false;
        int after = b / gcd(a, b);
        if(after==1) return 1;
        for (int i = 1; i <= after; i++) {
            if ((after % i == 0) && isPrime(i)) {
                list.add(i);
            }
        }
        System.out.println(list);

        if (list.size() >= 2) {
            if (list.get(0) == 2 && list.get(1) == 5) return 1;
        } else {
            if (list.get(0) == 2) return 1;
            if (list.get(0) == 5) return 1;
        }
        return 2;
    }

    public boolean isPrime(int a) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= a; i++) {
            if (a % i == 0) {
                list.add(i);
            }
        }
        if (list.size() == 2) return true;
        return false;
    }

    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

}