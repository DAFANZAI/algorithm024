public class MaxArea_11 {
    /**
     * 双指针法求解：定义两个指针分别指向数组首末，每次将指向较小元素的指针向中间移动直到两指针相遇
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int result = 0;
        int i = 0;
        int j = height.length - 1;
        while(i < j) {
            result = height[i] < height[j] ?
                    Math.max(result, (j - i) * height[i++]):
                    Math.max(result, (j - i) * height[j--]);
        }
        return result;
    }
}
