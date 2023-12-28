import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        String[][] matrix = new String[5][15];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                matrix[i][j] = line.substring(j, j + 1);
            }
        }
        int length = matrix[0].length;
        String answer = "";
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < 5; j++) {
                if (matrix[j][i] == null) {
                    answer += "";
                } else {
                    answer += matrix[j][i];
                }
            }
        }
        System.out.println(answer);
    }
}