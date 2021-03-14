import java.util.Stack;

public class LargestRectangleArea_84 {
    /**
     * 单调栈解法
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int left[] = new int[len];
        int right[] = new int[len];
        Stack<Integer> stack = new Stack<>();
        //遍历数组获取枚举每个柱子的左边界
        for(int i = 0; i < len; i++) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                //出栈
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        //遍历数组枚举每个柱子的右边界
        for(int i = len - 1; i >= 0; i--) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                //出栈
                stack.pop();
            }
            right[i] = stack.isEmpty() ? len : stack.peek();
            stack.push(i);
        }
        int result = 0;
        for(int i = 0; i < len; i++) {
            result = Math.max(result, (right[i] - left[i] - 1) * heights[i]);
        }
        return result;
    }
}
