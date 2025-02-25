import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            int number = Integer.parseInt(br.readLine());
            if (number == -1) break;

            int sum = 0;
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i < number; i++) {
                if (number % i == 0) {
                    sum += i;
                    list.add(i);
                }
            }
            if (sum != number) bw.write(number + " is NOT perfect.\n");
            else {
                bw.write(number + " = ");
                for (int a = 0; a < list.size(); a++) {
                    if (a != list.size() - 1) {
                        bw.write(list.get(a) + " + ");
                    } else bw.write(list.get(a) + "\n");
                }

            }
        }
        bw.flush();
        bw.close();
    }
}