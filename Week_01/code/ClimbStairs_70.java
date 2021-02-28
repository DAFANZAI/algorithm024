public class ClimbStairs_70 {
    /**
     * 递归解法：N阶楼梯爬法 = N-1阶楼梯爬法 + N-2阶楼梯爬法
     * leetcode提交会提示超出时间限制
     * @param n
     * @return
     */
    public int climbStairs1(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }

    /**
     * 采用迭代法求解：N阶楼梯需要循环N-2次
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        //n阶楼梯需要循环n-2次
        int result = 0, a = 1, b = 2;
        for(int i = 0; i < n - 2; i++) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }

}
