import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    // 투 포인터
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        // 0제외 중복 건너뛰기
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // 출력 형식 맞추기 asList
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 중복 숫자가 있을 경우 다른거 나올때까지 건너뛰기
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;

                } else if (sum < 0) {
                    left++;

                } else {
                    right--;
                }
            }
        }
        return ans;
    }
}
