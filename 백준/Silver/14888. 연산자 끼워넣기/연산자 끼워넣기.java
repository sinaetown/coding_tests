import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> operand = new ArrayList<>();
        int[] operator = new int[4];
        int ind = 0;

        for (int i = 0; i < N; i++) operand.add(Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) operator[ind++] = (Integer.parseInt(st.nextToken()));
        backtracking(operand, operator, 1, operand.get(0));
        System.out.println(max);
        System.out.println(min);
    }

    public static void backtracking(List<Integer> operand, int[] operator,
                                    int order, int res) {
        if (order == operand.size()) {
            if(min>res) min = res;
            if(max<res) max = res;
            return;
        }
        for (int i = 0; i < operator.length; i++) {
            if (operator[i] != 0) {
                if (i == 0) {
                    res += operand.get(order);
                    order++;
                    operator[i] -= 1;
                    backtracking(operand, operator, order, res);
                    order--;
                    operator[i] += 1;
                    res -= operand.get(order);
                } else if (i == 1) {
                    res -= operand.get(order);
                    order++;
                    operator[i] -= 1;
                    backtracking(operand, operator, order, res);
                    order--;
                    operator[i] += 1;
                    res += operand.get(order);
                } else if (i == 2) {
                    res *= operand.get(order);
                    order++;
                    operator[i] -= 1;
                    backtracking(operand, operator, order, res);
                    order--;
                    operator[i] += 1;
                    res /= operand.get(order);
                } else if (i == 3) {
                    res /= operand.get(order);
                    order++;
                    operator[i] -= 1;
                    backtracking(operand, operator, order, res);
                    order--;
                    operator[i] += 1;
                    res *= operand.get(order);
                }
            }
        }
    }
}