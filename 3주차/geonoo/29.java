import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        // 우선순위 큐를 사용하여 최소 힙을 생성
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 모든 스코빌 지수를 우선순위 큐에 추가
        for (int s : scoville) {
            pq.offer(s);
        }

        int count = 0;

        // 최소 힙의 최솟값이 K 이상이 될 때까지 반복
        while (pq.size() > 1 && pq.peek() < K) {
            int first = pq.poll();
            int second = pq.poll();
            int newScoville = first + (second * 2);
            pq.offer(newScoville);
            count++;
        }

        // 모든 음식의 스코빌 지수가 K 이상이 되지 못할 경우
        if (pq.peek() < K) {
            return -1;
        }

        return count;
    }
}