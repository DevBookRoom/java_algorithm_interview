public class Number7 {

  public static void main(String[] args) {

    SolutionNo7 solution = new SolutionNo7();
    int[] result = solution.twoSum(new int[] { 3, 2, 4, }, 6);
  }
}

class SolutionNo7 {

  public int[] twoSum(int[] nums, int target) {

    // for문 돌려서 하나씩 하나씩 값을 더한 후 target값이 나오면 종료
    int[] result = new int[2];

    int cnt = 1;
    for (int i = 0; i < nums.length; i++) {
      if (cnt == nums.length) {
        break;
      }
      for (int j = cnt; j < nums.length; j++) {
        int sum = nums[i] + nums[j];
        if (sum == target) {
          result[0] = i;
          result[1] = j;
          System.out.println(result[0] + ", " + result[1]);
          return result;
        }
      }
      cnt++;
    }
    return result;
  }
}