import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int total = -1;
        for (int i = 1; i <= n; i++) {
            int left = leftChk(i, arr[i]);
            int right = rightChk(i, arr[i]);
            int tmp = right + left;
            if (tmp > total) {
                total = tmp;
            }
        }
        if (total == -1) {
            System.out.println(0);
            return;
        }
        System.out.println(total);
    }

    public static int leftChk(int x, int y) {
        int cnt = 0;
        double current = 1000000001.0;
        for (int i = x - 1; i >= 1; i--) {
            int x2 = i;
            int y2 = arr[i];
            double tmp = (((double) y2 - (double) y) / (double) (x2 - x));
            if (current > tmp) {
                current = tmp;
                cnt++;
            }
        }
        return cnt;
    }

    public static int rightChk(int x, int y) {
        int cnt = 0;
        double current = -1000000001.0;
        for (int i = x + 1; i < arr.length; i++) {
            int x2 = i;
            int y2 = arr[i];
            double tmp = (((double) y2 - (double) y) / (double) (x2 - x));
            if (current < tmp) {
                current = tmp;
                cnt++;
            }
        }
        return cnt;
    }

}