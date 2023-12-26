import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        Queue<Integer> pqA = new PriorityQueue<>((o1, o2) -> o1 - o2); //min pq
        Queue<Integer> pqB = new PriorityQueue<>((o1, o2) -> o2 - o1); //max pq

        for (int a : A) {
            pqA.add(a);
        }
        for (int b : B) {
            pqB.add(b);
        }
        int sum = 0;
        int count=0;
        while (!pqA.isEmpty()) {
            sum+=pqA.poll()*pqB.poll();
            count++;
        }
        return sum;
    }
}