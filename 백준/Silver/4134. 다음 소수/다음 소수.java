import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int z = 0; z < n; z++) {
            long num = Long.parseLong(br.readLine());
            if (num == 0 || num == 1 || num == 2) {
                System.out.println(2);
                continue;
            }
            while (true) {
                boolean flag = true;
                for (int i = 2; i < Math.sqrt(num) + 1; i++) {
                    if (num % i == 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    System.out.println(num);
                    break;
                }
                num++;
            }
        }
    }
}
