import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int[] solution(String[] operations) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (String operation : operations) {
            // 띄어쓰기를 기준으로 명령과 값 분리
            String[] parts = operation.split(" ");
            String command = parts[0];
            int number = Integer.parseInt(parts[1]);

            if (command.equals("I")) {
                // 삽입 연산
                minHeap.add(number);
                maxHeap.add(number);
            } else if (command.equals("D")) {
                // 삭제 연산
                if (number == 1 && !maxHeap.isEmpty()) {
                    // 최대값 삭제
                    int maxValue = maxHeap.poll();
                    minHeap.remove(maxValue);
                } else if (number == -1 && !minHeap.isEmpty()) {
                    // 최솟값 삭제
                    int minValue = minHeap.poll();
                    maxHeap.remove(minValue);
                }
            }
        }

        // 큐가 비어있으면 [0, 0]을 반환
        if (minHeap.isEmpty()) {
            return new int[]{0, 0};
        } else {
            // 아니라면 max, min 힙을 반환
            return new int[]{maxHeap.peek(), minHeap.peek()};
        }
    }
}
