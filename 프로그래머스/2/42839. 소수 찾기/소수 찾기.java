import java.util.*;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        Set<Integer> total = new HashSet<>();
        for (int i = 0; i < numbers.length(); i++) {
            list.add(Integer.parseInt(Character.toString(numbers.charAt(i))));
        }

        boolean[] visited = new boolean[list.size()];
        for (int i = 1; i <= list.size(); i++) {
            perm(list, new ArrayList<>(), visited, 0, i, total);
        }
         
        if(total.contains(1)) total.remove(0);
        for (int a : total) {

            if (isPrime(a)) answer++;
        }
        return answer;
    }

    public void perm(List<Integer> given,
                            List<Integer> tmp,
                            boolean[] visited,
                            int depth,
                            int r,
                            Set<Integer> total) {
        if (depth == r) {
            StringBuilder sb = new StringBuilder();
            for (int i : tmp) sb.append(i);
            total.add(Integer.parseInt(sb.toString()));
            return;
        }
        for (int i = 0; i < given.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                tmp.add(given.get(i));
                perm(given, tmp, visited, depth + 1, r, total);
                tmp.remove(tmp.size() - 1);
                visited[i] = false;
            }
        }
    }

    public boolean isPrime(int num) {
        if(num==1) return false;
        if(num==0) return false;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}