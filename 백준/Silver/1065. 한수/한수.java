import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String numStr = sc.next();
        int num = Integer.parseInt(numStr);
        int count = 99;
        if (num <= 99) {
            System.out.println(num);
        } else {
            for (int i = 100; i <= num; i++) {
                List<Integer> numlist = new ArrayList<>();
                int j = i;
                while (j > 0) {
                    numlist.add(j % 10);
                    j /= 10;
                }
//                System.out.println(numlist);
                if ((numlist.get(1) - numlist.get(0)) == (numlist.get(2) - numlist.get(1))) {
                    count++;
                }
            }
            if(num==1000) count-=1;
            System.out.println(count);
        }
    }
}
