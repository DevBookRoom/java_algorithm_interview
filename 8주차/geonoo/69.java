class Solution {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                // 0을 발견하면 low와 mid를 swap하고 둘 다 증가
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // 1이면 그냥 mid 증가
                mid++;
            } else if (nums[mid] == 2) {
                // 2를 발견하면 mid와 high를 swap하고 high만 감소
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
}
