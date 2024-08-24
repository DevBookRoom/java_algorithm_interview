import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Number81 {


    public static void main(String[] args) {
        Number81 num = new Number81();
        int[] result = num.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,8},3);
    }

    public int[] maxSlidingWindow( int[] nums , int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            // 윈도우 값 범위 넘어가는 순간 해당 값을 제거
            if (!dq.isEmpty() && dq.peek() < i - k + 1) {
                // 맨 앞 원소 삭제
                dq.poll();
            }

            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
            // 데크에 인덱스 값  추가
            dq.add(i);

            // 데크에서 가장 앞단이 큰 값이니까 추가 윈도우 사이즈만큼 진행 후
            if (i >= k - 1) {
                // 데크에 인덱스값 반환해서 result에 넣음
                result.add(nums[dq.peek()]);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
