import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int nn = 0; nn < n; nn++) {
            int quarter = 0;
            int dime = 0;
            int nickel = 0;
            int penny = 0;
            int cents = Integer.parseInt(br.readLine());
            if (cents / 25 != 0) {
                quarter = cents / 25;
                cents -=quarter*25;
            }
            if (cents / 10 != 0) {
                dime = cents / 10;
                cents -=  dime*10;
            }
            if (cents / 5 != 0) {
                nickel = cents / 5;
                cents -= nickel*5;
            }
            penny = cents;
            bw.write(quarter + " " + dime + " " + nickel + " " + penny + "\n");
        }

        bw.flush();
        bw.close();
    }

}