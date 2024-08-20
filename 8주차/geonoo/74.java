class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 시작 위치를 오른쪽 위 모서리로 설정
        int row = 0;
        int col = matrix[0].length - 1;

        // 행렬 범위 내에서 반복
        while (row < matrix.length && col >= 0) {
            int value = matrix[row][col];

            if (value == target) {          // 정답 찾았으면 true
                return true;
            } else if (value > target) {    // 값이 타깃보다 크면 앞 열로 ㄱㄱ -> why? 행 기준으로 정렬되어 있기 때문.
                col--;
            } else {                        // 값이 타깃보다 작으면 다음 행으로 -> why? 현재값이 각 행의 최대값이므로 이것보다 작으면 이 행은 탐색할 필요 x
                row++;
            }
        }
        return false;
    }
}
