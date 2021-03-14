public class MinPathSum_64 {
    /**
     * 动态规划
     * 1、状态矩阵：dp为m*n，dp[i][j]代表走到(i, j)的最小路径和
     * 2、状态转移方程：只能向右或者向下走
     * i != 0 && j != 0 -> dp[i][j] = min(dp[i - 1][j], dp[i][j-1]) + grid[i][j]
     * i = 0 && j != 0 -> dp[i][j] = dp[i][j - 1] + grid[i][j]
     * j != 0 && j = 0 -> dp[i][j] = dp[i - 1][j] + grid[i][j]
     * i = 0 && j = 0 -> dp[i][j] = grid[i][j]
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(i == 0 && j == 0) continue;
                else if(i == 0) grid[i][j] = grid[i][j - 1] + grid[i][j];
                else if(j == 0) grid[i][j] = grid[i - 1][j] + grid[i][j];
                else grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
