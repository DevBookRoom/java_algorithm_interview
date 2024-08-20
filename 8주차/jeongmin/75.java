import java.util.Arrays;
class Solution {
    //n=3 , times=[3,4]
    public long solution(int n, int[] times) {
        long answer = 0;
        long left = 1;

        // 맨 오른쪽은 (입력 값 중 가장 큰 값 * n)을 가능한 최댓값으로 설정
        long right = (long) Arrays.stream(times).max().getAsInt() * n;
//4*3
        // 초기 중앙값은 맨 오른쪽 값으로 설정
        long mid = right;

        while (left <= right) {
            long sum = 0;

            // 소요시간(중앙값)을 각 심사관의 시간으로 나누고 합산한 값 계산
            for (long time : times) {
                sum += (mid / time);//12/3 + 12/4= 7 ->6/3+6/4=3
            }

            // 합산값이 기다리는 사람 수보다 크거나 같으면 중앙값(소요시간)을 정답으로 설정
            if (sum >= n) { //7>=3->3=3
                answer = mid; //12 ->3
                right = mid - 1; // 11->2
            } else {
                left = mid + 1;
            }

            // 중앙값 계산
            mid = left + (right - left) / 2;//1+10/2=6
        }

        return answer;
    }


}

