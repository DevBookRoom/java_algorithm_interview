import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // 우선순위 큐 선언 및 정렬. 정렬 기준은 큰 키 우선, 값이 같다면 앞에 줄 서 있는 사람이 작은 순으로
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);

        // 우선순위 큐에 입력값 삽입
        for (int[] person : people) {
            pq.add(person);
        }

        List<int[]> result = new ArrayList<>();
        // 우선순위 큐에서 모두 추출할 때까지 반복
        while (!pq.isEmpty()) {
            // 큰 키 우선, 앞에 줄 서 있는 사람이 적은 순으로 추출
            int[] person = pq.poll();
            // 앞에 줄 서 있는 사람을 인덱스로 정해서 삽입
            result.add(person[1], person);
        }

        return result.toArray(new int[people.length][2]);
    }
}
