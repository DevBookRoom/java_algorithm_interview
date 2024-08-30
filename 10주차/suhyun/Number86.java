class Solution {
    public int leastInterval(char[] tasks, int n) {
        int al[] = new int[26];
        int max = 0;
        int idx = 0;
        for (char task : tasks) {
            al[task - 'A']++;
            if (al[task - 'A'] > max) {
                max = al[task - 'A'];
                idx = task - 'A';
            }
        }
        int plus = 0;
        int idle = (al[idx] - 1) * n;
        for (int i = 0; i < 26; i++) {
            if (idle == 0)
                break;
            if (al[i] == 0 || i == idx)
                continue;
            int tmp = Math.min(max - 1, al[i]);
            idle -= tmp;
            if (idle < 0) {
                plus = Math.abs(idle);
                break;
            }
        }
        int answer = idle + tasks.length + plus;
        return answer;
    }
}