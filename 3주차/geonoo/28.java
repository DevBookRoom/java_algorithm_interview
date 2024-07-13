import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Point 클래스를 저장하는 우선순위 큐로, 정렬 기준은 distance로 한다.
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a.distance));

        // 파라미터로 받은 좌표 목록 순회
        for (int[] point : points) {
            // 유클리드 거리 계산
            long distance = (long) point[0] * point[0] + (long) point[1] * point[1];
            // 우선순위 큐에 거리와 좌표를 Point 클래스로 담아 삽입
            pq.add(new Point(distance, point));
        }

        int[][] results = new int[k][];
        // k번 만큼 반복하여 결과 추출
        for (int i = 0; i < k; i++) {
            results[i] = pq.poll().point;
        }

        return results;
    }

    static class Point {
        long distance;
        int[] point;

        // 거리와 좌표를 파라미터로 받는다
        public Point(long distance, int[] point) {
            this.distance = distance;
            this.point = point;

        }
    }
}
