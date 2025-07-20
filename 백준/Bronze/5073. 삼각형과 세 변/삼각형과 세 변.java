import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String line = br.readLine();
            if (line.equals("0 0 0")) break;
            StringTokenizer st = new StringTokenizer(line);
            Set<Integer> set = new HashSet<>();
            int[] arr = new int[3];
            for (int i = 0; i < 3; i++) {
                int given = Integer.parseInt(st.nextToken());
                set.add(given);
                arr[i] = given;
            }
            Arrays.sort(arr);
            if (arr[0] + arr[1] <= arr[2]) bw.write("Invalid\n");
            else {
                if (set.size() == 3) bw.write("Scalene\n");
                else if (set.size() == 2) bw.write("Isosceles\n");
                else if (set.size() == 1) bw.write("Equilateral\n");
            }
        }
        bw.flush();
    }


}