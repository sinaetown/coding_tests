import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[7][2]; //학년, 성별
        int sum = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[y][s]++;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < 2; j++) {
                if (arr[i][j] != 0) {
                    if (k == 1) sum += arr[i][j];
                    else if (arr[i][j] % k == 0) sum += arr[i][j] / k;
                    else if (arr[i][j] % k != 0) sum += arr[i][j] / k + 1;
                }
            }
        }
//        System.out.println(Arrays.deepToString(arr));
        System.out.println(sum);
    }
}