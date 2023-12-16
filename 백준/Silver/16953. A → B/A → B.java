import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        int count = 1;
        long temp = b;
        while (a < temp) {
            String str = String.valueOf(temp);
            if (temp % 2 == 0) {
                temp /= 2;
                count++;
            } else if (str.substring(str.length() - 1, str.length()).equals("1")) {
                temp = Long.parseLong(str.substring(0, str.length() - 1));
                count++;
            } else {
                break;
            }
        }
        if (a != temp) {
            count = -1;
        }
        System.out.println(count);
    }
}
