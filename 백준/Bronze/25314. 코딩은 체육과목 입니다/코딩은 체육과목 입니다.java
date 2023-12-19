import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        n-=4;
        String s = "long int";
        while(n!=0){
            s="long "+s;
            n-=4;
        }
        System.out.println(s);
    }
}
