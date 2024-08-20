import java.util.Arrays;

class Solution {
    public int search(int[] nums, int target) {
        // 찾는 값이 없으면 0 미만의 값이 나오기에 -1 리턴
        return Arrays.binarySearch(nums, target) >= 0 ? Arrays.binarySearch(nums, target) : -1;
    }
//    public int search(int[] nums, int target) {
//        return binarySearch(nums, target, 0, nums.length - 1);
//    }
//
//    public int binarySearch(int[] nums, int target, int left, int right) {
//        if (left <= right) {
//            int mid = (left + right) / 2;
//
//            if (nums[mid] < target) {
//                return binarySearch(nums, target, mid + 1, right);
//            } else if (nums[mid] > target) {
//                return binarySearch(nums, target, left, mid - 1);
//            } else {
//                return mid;
//            }
//        } else {
//            // 모두 탐색했지만 정답이 없으면 -1
//            return -1;
//        }
//    }
}
