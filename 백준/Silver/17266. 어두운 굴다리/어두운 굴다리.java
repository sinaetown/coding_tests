import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        arr = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int left = 1; // 굴다리 최소 길이
        int right = n; // 굴다리 최대 길이
        int result = 0; // 최소 높이
        while (left <= right) {
            int mid = (left + right) / 2; // 가로등의 높이
            if (possible(mid, n)) { // 해당 높이가 다 비춘다면, 범위 줄여서 확인해보기
                result = mid;
                right = mid - 1;
            } else left = mid + 1;// 해당 높이가 다 비추지 못한다면, mid값 올리기
        }
        System.out.println(result);
    }

    public static boolean possible(int target, int n) {
        int prev = 0; // 이전 가로등이 비춘 마지막 지점
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - target <= prev) { // 가로등이 비추는 최솟값 <= 그 전 가로등이 비췄던 마지막 지점
                prev = arr[i] + target;
            } else return false;
        }
        return n <= prev; // 마지막 지점의 가로등이 비추는 값이 n 보다 커야 다 비출 수 있음
    }
}