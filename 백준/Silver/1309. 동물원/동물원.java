import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 1;
        int one = 1, two = 1, nope = 1;
        while (cnt < n) {
            cnt++;
            int updatedOne = one % 9901 + nope % 9901;
            int updatedTwo = updatedOne;
            int updatedNope = one % 9901 + two % 9901 + nope % 9901;
            one = updatedOne;
            two = updatedTwo;
            nope = updatedNope;
        }
        System.out.println((one + two + nope) % 9901);
    }
}