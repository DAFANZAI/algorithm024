public class Search_33 {
    /**
     * 采用二分法求解：
     * 这样写放到leetcode上执行提示超出时间限制，同样用的二分查找算法，只是归约边界判定条件写的繁琐，复杂度应该还是O(logN)
     * @param nums
     * @param target
     * @return
     */
//    public static int search(int[] nums, int target) {
//        int begin = 0;
//        int end = nums.length - 1;
//        int mid = (end + begin) / 2;
//        while(end - begin > 0) {
//            if(nums[mid] < nums[begin]) {
//                if(target < nums[mid]) {
//                    end = mid;
//                }else if(target > nums[end]) {
//                    end = mid;
//                }else {
//                    begin = mid;
//                }
//            }else {
//                if(target > nums[mid]) {
//                    begin = mid;
//                }else if(target < nums[begin]) {
//                    begin = mid;
//                }else {
//                    end = mid;
//                }
//            }
//            mid = (end + begin) / 2;
//        }
//        return nums[begin] == target ? begin : -1;
//    }

    /**
     * 二分法求解：简化规约边界判定条件
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        int begin = 0;
        int end = nums.length - 1;
        while (begin < end) {
            int mid = (begin + end) / 2;
            // 当[0,mid]有序时,向后规约条件
            if (nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0])) {
                begin = mid + 1;
                // 当[0,mid]发生旋转时,向后规约条件
            } else if (target > nums[mid] && target < nums[0]) {
                begin = mid + 1;
            } else {
                end = mid;
            }
        }
        return nums[begin] == target ? begin : -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(nums, 0));
    }
}
