import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> list = primeList(N);
        int left = 0, right = 0;
        int sum = 0, cnt = 0;
        while (left <= right) {
            if (right >= list.size()) {
                left++;
                right = left;
                sum = 0;
            }
            if (left >= list.size()) {
                break;
            }
            if (sum < N) {
                sum += list.get(right);
                right++;
            }
            if (sum == N) {
                cnt++;
                left++;
                right = left;
                sum = 0;
            }
            if (sum > N) {
                left++;
                right = left;
                sum = 0;
            }

        }
        System.out.println(cnt);
    }

    public static List<Integer> primeList(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) list.add(i);
        }
        return list;
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        else {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) return false;
            }
        }
        return true;
    }
}