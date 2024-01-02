import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());
        double sum = 0;
        for (int i = N.length() - 1; i >= 0; i--) {
            if (Character.isDigit(N.charAt(i))) {
                int mul = 1;
                for (int j = N.length() - 1; j > i; j--) {
                    mul *= B;
                }
                sum += (N.charAt(i) - '0') * mul;

            } else {
                int mul2 = 1;
                for (int j = N.length() - 1; j > i; j--) {
                    mul2 *= B;
                }
                sum += ((int) N.charAt(i) - 55) * mul2;
            }

        }
        System.out.println((int) sum);
    }
}
