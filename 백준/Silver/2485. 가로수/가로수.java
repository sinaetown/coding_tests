import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        int gcd = 0;
        for (int n = 0; n < N; n++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);

        for (int i = 0; i < list.size() - 1; i++) {
            gcd = gcd(gcd, list.get(i + 1) - list.get(i));
        }

        System.out.println((list.get(list.size() - 1) - list.get(0)) / gcd + 1 - list.size());
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

}
