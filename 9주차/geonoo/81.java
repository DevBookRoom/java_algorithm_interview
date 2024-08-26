import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    // 데크는 슬라이딩 윈도우 내에서 유효한 인덱스를 유지
    // 각 단계마다 데크의 앞에는 현재 윈도우 내의 최대값 인덱스가 오도록 함 --> 이게 중요!!
    // 윈도우가 배열의 첫 부분을 지나면서부터 최대값을 결과 리스트에 추가

    // 데크로 최적화
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        // 인덱스 저장용 데크 선언
        Deque<Integer> dq = new ArrayDeque<>();

        // 배열 전체 순회
        for (int i = 0; i < nums.length; i++) {
            // 데크 맨 앞이 윈도우 바깥에 있다면 삭제. 윈도우 시작 인덱스(i - k + 1) 이전에 있는 인덱스는 더 이상 고려대상 아님.
            if (!dq.isEmpty() && dq.peek() < i - k + 1) {
                dq.poll();
            }

            // 현재 값보다 작으면 데크에서 모두 삭제, 데크에는 현재 값보다 큰 인덱스만 남는다.
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            // 현재 인덱스 추가
            dq.add(i);

            // 데크의 첫 번째 값은 가장 큰 값이므로 정답으로 추가
            if (i >= k - 1) {
                result.add(nums[dq.peek()]);
            }
        }
        // List<Integer> -> int[] 변환하여 리턴
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    // 브루트 포스 -> 시간복잡도 O(k*n)
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        // 예외 처리
//        if (nums.length == 0) {
//            return new int[0];
//        }
//
//        List<Integer> result = new ArrayList<>();
//        // 배열 전체를 순회하며 슬라이드 윈도우별 최댓값을 구함.
//        for (int i = 0; i < nums.length - k + 1; i++) {
//            // 첫 번째 값을 최댓값으로 임시 선언
//            int max = nums[i];
//            // k 크기만큼 순회하며 최댓값 구하기
//            for (int j = i + 1; j < i + k; j++) {
//                if (nums[j] > max) {
//                    max = nums[j];
//                }
//            }
//            result.add(max);
//        }
//        // List<Integer> -> int[] 변환하여 리턴
//        return result.stream().mapToInt(Integer::intValue).toArray();
//    }
}
