import java.util.Arrays;

public class Solution {
    // 투 포인터
//    public int[] twoSum(int[] numbers, int target) {
//        int left = 0;
//        int right = numbers.length - 1;
//
//        while (left != right) {
//            if (numbers[left] + numbers[right] < target) {
//                left++;
//            } else if (numbers[left] + numbers[right] > target) {
//                right--;
//            } else {
//                return new int[]{left + 1, right + 1};
//            }
//        }
//        return null;
//    }

    // 이진 탐색
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            // 타깃에서 현재 값을 뺀, 찾아야 하는 값 지정
            int expected = target - numbers[i];
            // 이진 탐색 메서드 (array, fromIndex, toIndex, key)
            int idx = Arrays.binarySearch(numbers, i + 1, numbers.length - 1, expected);

            // 인덱스가 0 이상인 값이면 값을 찾은 것이므로 결과 리턴
            if (idx >= 0) {
                return new int[]{i + 1, idx + 1};
            }
        }
        return null;
    }
}
