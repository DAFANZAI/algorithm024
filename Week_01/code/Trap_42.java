public class Trap_42 {
    /**
     * 基本思路：按列求解，寻找当前列左边最高的墙max_lef和右边最高的墙max_right
     * min(max_lef, max_right) - height如果小于0则等于0
     * 动态规划解法：定义两个数组分别存储第i列左右两边最高墙的高度，不用再循环遍历求解
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int sum = 0;
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];
        for(int i = 1; i < height.length - 1; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
        }
        for(int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
        for(int i = 1; i < height.length - 1; i++) {
            int min = Math.min(max_left[i], max_right[i]);
            if(min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }
}
