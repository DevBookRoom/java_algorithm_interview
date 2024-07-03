import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<Integer>> threeSum(int[] numbers) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 2; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) continue;
            int j = i + 1;
            int k = numbers.length - 1;
            // -4 -1 -1 0 1 2
            while (j < k) {
                int n = numbers[i] + numbers[j] + numbers[k];
                if (n > 0) {
                    k--;
                } else if (n < 0) {
                    j++;
                } else {
                    res.add(Arrays.asList(numbers[i], numbers[j], numbers[k]));
                    while (j < k && numbers[j] == numbers[j + 1]) j++;
                    while (j < k && numbers[k] == numbers[k - 1]) k--;
                    j++;
                    k--;
                }
            }
        }
        return res;
    }
}