import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int num = sc.nextInt();
        for(int i = 0; i < num ; i++){
            for(int jj = 0; jj < num-i-1; jj++){
                System.out.print(" ");
            }
            for(int j = 0; j < i+1; j++){
                System.out.print("*");
            }
            System.out.println();
        }

    }
}