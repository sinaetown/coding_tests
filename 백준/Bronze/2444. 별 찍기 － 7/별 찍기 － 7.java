import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int count = 0;
        int blank_count = n - 1;
        int blank2_count = 1;
        String[] arr = new String[n * 2 - 1];

        Arrays.fill(arr, "");
        for (int i = 0; i < n; i++) {
            count += 2;
            for (int k = 0; k < blank_count; k++) {
//                arr[i] += " ";
                System.out.print(" ");
            }
            for (int j = 0; j < count - 1; j++) {
//                arr[i] += "*";
                System.out.print("*");
            }
//            for (int k = 0; k <= blank_count + 1; k++) {
//                arr[i] += " ";
//                System.out.print(" ");
//            }
//            arr[i] += "\n";
            System.out.println();
            blank_count--;
        }
        int count2 = count;
        for (int i = 0; i < n-1; i++) {
            count2 -= 2;
            for (int k = 0; k < blank2_count; k++) {
//                arr[n + i - 1] += " ";
                System.out.print(" ");
            }
            for (int j = 0; j < count2 - 1; j++) {
//                arr[i + n - 1] += "*";
                System.out.print("*");
            }
//            for (int m = 0; m <= blank2_count + 1; m++) {
//                arr[i + n - 1] += " ";
//                System.out.print(" ");
//            }
//            arr[i + n - 1] += "\n";
            System.out.println();
            blank2_count++;
        }
//        for (int i = 0; i < arr.length-1; i++) {
//            System.out.print(arr[i]);
//        }
    }
}
