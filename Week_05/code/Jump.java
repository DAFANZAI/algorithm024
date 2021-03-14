import java.util.Arrays;

public class Jump {
    public static int jump(int[] nums) {
        //采用递归解法
        if(nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        int result = 0;
        for(int i = 1; i <= nums[0]; i++) {
            if(i >= nums.length) {
                break;
            }
            if(nums[i] == 0 && i != nums.length - 1) continue;
            int temp = 1 + jump(Arrays.copyOfRange(nums, i, nums.length));
            if(temp > result && result != 0) {
                continue;
            }
            result = temp;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {3, 0, 2, 0, 2, 3, 0, 2, 0, 0};
        System.out.println(jump(a));
    }
}
