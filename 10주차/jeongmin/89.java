import java.util.*;

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> countsMap = new HashMap<>();

        // 숫자의 빈도를 계산
        for (int num : nums) {
            countsMap.put(num, countsMap.getOrDefault(num, 0) + 1);
        }

        // 빈도를 기준으로 내림차순 정렬
        Map<Integer, Integer> reverseSortedMap = new LinkedHashMap<>();
        countsMap.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

        // 첫 번째 엔트리가 과반수를 차지하는지 확인
        Map.Entry<Integer, Integer> entry = reverseSortedMap.entrySet().iterator().next();

        if (entry.getValue() > nums.length / 2) return entry.getKey();

        return -1;
    }
}
