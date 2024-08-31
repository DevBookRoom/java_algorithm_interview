class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0, currentGas = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            currentGas = gas[i] - cost[i];

            // 현재 연료가 음수가 되면, 다음 출발점으로 갱신
            if (currentGas < 0) {
                start = i + 1;
                currentGas = 0;
            }
        }

        // 전체 가스가 전체 비용보다 많으면 순회가 가능
        if (totalGas >= totalCost) {
            return start;
        } else {
            return -1;
        }
    }
}
