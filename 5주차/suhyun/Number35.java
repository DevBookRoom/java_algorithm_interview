class Solution {
    public int numIslands(char[][] grid) {

        int answer = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    answer++;
                }
            }
        }
        return answer;
    }

    void dfs(int i, int j, char[][] grid) {

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        // 다음번에 또 안돌릴려고
        grid[i][j] = '0';

        // 동서남북으로 이동시키면서 재귀
        dfs(i, j + 1, grid);
        dfs(i, j - 1, grid);
        dfs(i + 1, j, grid);
        dfs(i - 1, j, grid);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] grid = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0', }, { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' } };

        solution.numIslands(grid);
    }
}