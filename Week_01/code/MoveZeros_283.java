public class MoveZeros_283 {
    /**
     * 暴力解法：第一层循环数组中每个元素；第二层循环把数组元素向前移动至前一个为非零元素的位置
     * 复杂度：O(n^2)
     * @param nums
     */
    public void moveZeroes1(int[] nums) {
        for(int i = 1; i <nums.length; i++) {
            if(nums[i] != 0) {
                for(int j = i - 1; j >= 0; j--) {
                    if(nums[j] == 0) {
                        nums[j] = nums[j + 1];
                        nums[j + 1] = 0;
                    }else {
                        break;
                    }
                }
            }
        }
    }

    /**
     * 双指针法：定义两个指针，一个指针遍历数组，一个指针查找第一个0元素
     * 复杂度：O(n)
     * @param nums
     */
    public void moveZeroes2(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                if(i != j) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
                j++;
            }
        }
        for(; j < nums.length; j++) {
            nums[j] = 0;
        }
    }
}
