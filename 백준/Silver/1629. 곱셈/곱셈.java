import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(st.nextToken());
        long answer = 1;
        if (a > c) {
            a %= c; // 나머지끼리 연산해도 결과는 같다
        }
        while (true) {
            if (b == 1) break;
            if (b % 2 == 1) { 
                answer = (answer * a) % c; // 따로 A를 빼내고, b를 짝수로 만들어준다
                b--;
            }
            a = (a * a) % c; //지수를 줄이는 과정과 분배법칙
            b /= 2;
        }
        answer = (answer * a) % c;
        System.out.println(answer);
    }
}