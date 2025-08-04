import java.io.*;
import java.util.*;

public class Main {
    public static int[] arr;
    public static int n;
    public static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int left = 0;
        int right = arr[n - 1] - arr[0]; // 집 간 최대 거리
        int res = 0;
        while (left <= right) {
            int mid = (left + right) / 2; // 공유기 간 거리
            int cnt = 1; // 설치한 공유기 개수
            int prevPos = arr[0]; // 첫번째 공유기는 첫 집에 위치시킨다

            for (int i = 1; i < n; i++) {
                if (arr[i] - prevPos >= mid) {
                    cnt++; // 공유기 설치 하나 더
                    prevPos = arr[i]; // 공유기의 마지막 위치
                }
            }
            if (cnt >= m) { // 공유기가 넉넉하게 설치가 되었을 경우
                // 범위를 더 넓혀도 됨
                res = mid;
                left = mid + 1;
            } else right = mid - 1;
        }
        System.out.println(res);
    }
}