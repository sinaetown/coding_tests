import java.io.*;
import java.util.*;

public class Main {
    public static long n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Long.parseLong(br.readLine());
        long sum = 0;
        int cnt = 0;
        int i = 1;
        while (true) {
            if (sum > n) break;
            sum += i;
            i++;
            cnt++;
        }
        System.out.println(cnt - 1);
    }
}