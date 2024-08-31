import java.util.Arrays;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        // 각 작업의 빈도수 계산 및 초기화 (문자 단위)
        // ex) 'A'는 freq[0], 'B'는 freq[1], ...
        int[] freq = new int[26];
        for (char c : tasks) {
            freq[c - 'A']++;
        }

        Arrays.sort(freq);      // 빈도 오름차순 정렬

        int maxFreq = freq[25];         // 가장 많이 나온 빈도
        int idle = (maxFreq - 1) * n;   // 초기 아이들 타임 계산

        // 남은 작업들로 아이들 시간 채움 -> 비교해서 더 작은 값을 초기 아이들 타임에서 빼줌.
        for (int i = 24; i >= 0 && idle > 0; i--) {
            idle -= Math.min(maxFreq - 1, freq[i]);
        }

        // idle이 0보다 작을 수는 없기에, 음수가 되면 0으로 보정해줌.
        idle = Math.max(0, idle);

        // 최종적으로 전체 작업 개수 + 생성된 아이들 작업 개수가 모든 작업을 수행하기 위한 최소 갯수가 됨.
        return tasks.length + idle;
    }
}
