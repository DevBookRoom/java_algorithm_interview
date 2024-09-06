public class Num93 {


        public static int climbStairs(int n) {
            return dfs(n);
        }

        private static int dfs(int stepsRemaining) {

            if (stepsRemaining == 0) {
                return 1;
            }
            if (stepsRemaining < 0) {
                return 0; // 잘못된 경로
            }

            // 1단계 또는 2단계를 밟는 두 가지 가능성을 탐색
            return dfs(stepsRemaining - 1) + dfs(stepsRemaining - 2);
        }

        public static void main(String[] args) {
            int n = 3; // 예제 입력
            int result = climbStairs(n);
        }

}
