import java.util.HashMap;
import java.util.Map;

class Solution {
    int[] twoSum(int[] nums, int target) {
        int len = nums.length;

        // 조회 구조 개선
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(nums[i], i);
        }

        int[] results = new int[2];

        for (int i = 0; i < len; i++) {
            int key = target - nums[i];
            var value = map.get(key);
            if (value != null && value != i) {
                results[0] = i;
                results[1] = value;
                break;
            }
        }

        return results;
    }
}