import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = -1;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new int[]{a, b});
        }
        //별똥별들의 x좌표 중 하나를 왼쪽 경계로
        //별똥별들의 y좌표 중 하나를 아래 경계로
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                int cnt = 0;
                for (int p = 0; p < list.size(); p++) {
                    //해당 별똥별
                    if (list.get(i)[0] <= list.get(p)[0]
                            && list.get(p)[0] <= list.get(i)[0] + l
                            && list.get(j)[1] <= list.get(p)[1]
                            && list.get(p)[1] <= list.get(j)[1] + l
                    ) cnt++;
                }
                max = Math.max(cnt, max);
            }
        }
        System.out.println(k - max);
    }
}