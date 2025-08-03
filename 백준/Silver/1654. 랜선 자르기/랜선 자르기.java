import java.io.*;
import java.util.*;

public class Main {
    public static List<Integer> list = new ArrayList<>();
    public static long max = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            list.add(num);
            max = Math.max(num, max);
        }
        max++;
        list.sort(null);
        System.out.println(upperBound(m));
    }

    public static long upperBound(int target) {
        //찾고자 하는 값을 초과한 값이 처음 나타나는 위치
        long min = 0;
        long mid = 0;
        while (min < max) {
            mid = (min + max) / 2;
            long cnt = 0;
            for (int i = 0; i < list.size(); i++) {
                cnt += (list.get(i) / mid);
            }
            if (cnt < target) {
                max = mid;
            } else min = mid + 1;
        }
        return min - 1;
    }

    public static int cal(int a) {
        int cnt = 0;
        for (int i = 0; i < list.size(); i++) {
            cnt += list.get(i) - a;
        }
        return cnt;
    }
}

