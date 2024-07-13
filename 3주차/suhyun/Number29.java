class Solution {
    public int solution(int[] scoville, int K) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int answer = 0;

        for (int i = 0; i < scoville.length; i++) {
            pq.offer(scoville[i]);
        }

        while (!pq.isEmpty()) {
            // 우선순위 작은 거 삭제 후 반환
            int current = pq.poll();

            if (current < K) {
                if (pq.size() == 0) {
                    return -1;
                }
                // 그 다음 작은 우선순위 반환
                int next = pq.poll();
                int sum = current + next * 2;

                // 요소 추가
                pq.offer(sum);
                answer++;

            }
        }
        return answer;
    }
}
