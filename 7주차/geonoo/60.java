import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // 최소 힙을 사용하기 위해 우선순위 큐 생성
        Queue<Integer> pq = new PriorityQueue<>(k);

        // 배열의 모든 요소에 대해 최소 힙에 모든 요소 추가
        for (int num : nums) {
            pq.add(num);
            // 최소 힙의 크기가 k를 초과하면, 가장 작은 요소를 제거.
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // k번째 마지막 값을 정답으로 리턴
        return pq.peek();
    }
}
