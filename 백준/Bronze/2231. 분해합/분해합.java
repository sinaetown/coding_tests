import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int n = 1; n <= N; n++) {
            if (n == N) {
                System.out.println("0");
                return;
            }
            if (n + calDigits(n) == N) {
                System.out.println(n);
                return;
            }
        }
    }

    public static int calDigits(int N) {
        int sum = 0;
        String n = String.valueOf(N);
        for (int i = 0; i < n.length(); i++) {
            sum += n.charAt(i) - '0'; // char->int
        }
        return sum;
    }
}