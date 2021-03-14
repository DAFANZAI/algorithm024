学习笔记

minPathSum:

     1、状态矩阵：dp为m*n，dp[i][j]代表走到(i, j)的最小路径和
     2、状态转移方程：只能向右或者向下走
     i != 0 && j != 0 -> dp[i][j] = min(dp[i - 1][j], dp[i][j-1]) + grid[i][j]
     i = 0 && j != 0 -> dp[i][j] = dp[i][j - 1] + grid[i][j]
     j != 0 && j = 0 -> dp[i][j] = dp[i - 1][j] + grid[i][j]
     i = 0 && j = 0 -> dp[i][j] = grid[i][j]
     
maximalSquare:
 
     1、状态矩阵：dp(i, j)表示以(i, j)为右下角，只包含1的正方形的边长最大值
     2、状态转移方程：
     matrix[i][j] == 0 -> dp(i, j) = 0
     matrix[i][j] == 1 -> dp(i, j) = min(dp(i - 1, j), dp(i, j - 1)) + 1
     matrix[i][j] == 1 && (i == 0 || j == 0) -> dp(i, j) = 1
      
注意：二维矩阵空防护判定条件

        `if(matrix == null || matrix.length == 0 || matrix[0].length ==0) {
            return 0;
        }`
