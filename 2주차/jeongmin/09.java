import java.util.Arrays;



class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        int left, right, sum;
        List<List<Integer>> results = new ArrayList<>();

        // 배열 정렬
        Arrays.sort(nums);

        // 간격 조절용 left, right 초기화 , 투 포인트 개념 활용
        for (int i = 0; i < nums.length; i++) {

            // 중복값 제거
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            left = i + 1;
            right = nums.length - 1;

            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];

                if (sum < 0) {
                    left += 1;
                } else if (sum > 0) {
                    right -= 1;
                } else {
                    // sum = 0인 경우
                    results.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 중복값 건너뛰기
                    while (left < right && nums[left] == nums[left + 1]) {
                        left += 1;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right -= 1;
                    }
                    left += 1;
                    right -= 1;
                }
            }

        }
        return results;
    }
}