import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int n;
    static int total = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        nQueen(0);
        System.out.println(total);
    }

    public static void nQueen(int cnt) {
        if (n == cnt) {
            total++;
            return;
        }
        for (int i = 0; i < n; i++) {
            arr[cnt] = i;
            if (possible(cnt)) nQueen(cnt + 1);
        }
    }


    public static boolean possible(int cnt) {
        for (int i = 0; i < cnt; i++) {
            if (arr[cnt] == arr[i]) return false;
            else if (Math.abs(cnt - i) == Math.abs(arr[cnt] - arr[i])) return false;
        }
        return true;
    }

}