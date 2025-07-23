import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); //필요 없음
            height[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int h : height) {
            if (h == 0) { //건물이 끝나는 (없는) 지점
                ans += stack.size();
                stack.clear();
            } else if (!stack.isEmpty()) {
                int peek = stack.peek();
                if (peek < h) {
                    stack.push(h);
                } else {
                    //만약 다음 건물이 높이가 더 낮다면 해당 건물은 끝남
                    //다음 건물의 높이가 더 높을 때까지 반복
                    while (!stack.isEmpty() && stack.peek() > h) {
                        stack.pop();
                        ans++;
                    }
                    //만약 다음 건물의 높이가 더 높다면 해당 건물을 추가
                    if (!stack.isEmpty() && stack.peek() < h) {
                        stack.push(h);
                    }
                    //stack이 비어있다면 무조건 추가
                    if (stack.isEmpty()) stack.push(h);
                }
            } else { //stack이 비어있다면 무조건 추가
                stack.push(h);
            }
        }
        ans += stack.size();
        System.out.println(ans);
    }
}