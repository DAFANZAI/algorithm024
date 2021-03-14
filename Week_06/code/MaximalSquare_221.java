public class MaximalSquare_221 {
    /**
     * 动态规划
     * 1、状态矩阵：dp(i, j)表示以(i, j)为右下角，只包含1的正方形的边长最大值
     * 2、状态转移方程：
     * matrix[i][j] == 0 -> dp(i, j) = 0
     * matrix[i][j] == 1 -> dp(i, j) = min(dp(i - 1, j), dp(i, j - 1)) + 1
     * matrix[i][j] == 1 && (i == 0 || j == 0) -> dp(i, j) = 1
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        //二维矩阵空防护判定条件
        if(matrix == null || matrix.length == 0 || matrix[0].length ==0) {
            return 0;
        }
        int maxSide = 0;
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                if(matrix[i][j] == '1') {
                    if(i == 0 || j == 0) {
                        dp[i][j] = 1;
                    }else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }
}
