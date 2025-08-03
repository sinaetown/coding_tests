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
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            list.add(num);
            max = Math.max(num, max);
        }
        max++;
        System.out.println(upperBound(m));
    }

    public static long upperBound(int target) {
        //찾고자 하는 값을 초과한 값이 처음 나타나는 위치
        long min = 0;
        long mid = 0;
        while (min < max) {
            mid = (min + max) / 2;
            long cnt = 0;
            cnt += cal(mid);
            if (cnt < target) {
                max = mid;
            } else min = mid + 1;
        }
        return min - 1;
    }

    public static long cal(long a) {
        long cnt = 0;
        for (int i = 0; i < list.size(); i++) {
            long res = list.get(i) - a;
            if (res >= 0) cnt += res;
        }
        return cnt;
    }
}

