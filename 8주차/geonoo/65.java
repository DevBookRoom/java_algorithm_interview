import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        // 시작 시간 기준으로 간격 정렬
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // 병합을 위한 리스트 생성
        List<int[]> merged = new ArrayList<>();

        // 첫 번째 간격 병합 리스트에 추가
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);


        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            // 겹치면 최대값 기준으로 병합
            if (currentEnd >= nextStart) {
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {    // 안겹치면 다음 간격 추가
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
