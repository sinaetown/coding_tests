import java.util.*;

public class Main {
    static List<Integer> given;
    static int five;

    static int sum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        given = new ArrayList<>();
        List<List<Integer>> all = new ArrayList<>();
        for (int i = 0; i < 10; i++) given.add(Integer.parseInt(st.nextToken()));
        List<Integer> sub = new ArrayList<>();
        five = 0;
        dfs(all, sub, 0, 1);
        System.out.println(sum);
    }

    static void dfs(List<List<Integer>> all, List<Integer> sub, int count, int start) {
        five=0;
        if (sub.size() >= 3 && ((sub.get(count - 3) == sub.get(count - 2)) &&
                (sub.get(count - 2) == sub.get(count - 1)))) {
            return;
        }
        if (sub.size() == 10) {
            for (int s = 0; s < sub.size(); s++) {
                if (sub.get(s) == given.get(s)) {
                    five++;
                }
            }
            if(five>=5){
                sum++;
            }
//            all.add(new ArrayList<>(sub));
        } else {
            for (int j = 1; j <= 5; j++) {
                sub.add(j);
                count++;
                dfs(all, sub, count, 1);
                count--;
                sub.remove(sub.size() - 1);
            }
        }
    }
}
