import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {
    /**
     * 采用三指针法求解：k,i,j
     * 1、先对数组进行排序
     * 2、k->依次遍历数组元素，i—>k指针后面首元素，j->k指针后面尾元素
     * 3、最外层for循环移动k指针
     * 4、假如data[k]>0直接跳过
     * 5、假如data[k]==data[k-1]直接跳过
     * 6、while：i不等于j
     *      计算data[i]+data[j]+data[k]的和，如果大于0？
     *      向右移动i指针，重复元素跳过:
     *      向左移动j指针，重复元素跳过
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        //对数组排序
        Arrays.sort(nums);
        //三指针法求解
        for(int k = 0; k < nums.length - 2; k++) {
            if(nums[k] > 0) break;
            if(k != 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1, j = nums.length - 1, sum = 0;
            while(i < j) {
                sum = nums[i] + nums[j] + nums[k];
                if(sum < 0) {
                    while(i < j && nums[i] == nums[i + 1]) i++;//去重
                    i++;
                }else if(sum > 0) {
                    while(i < j && nums[j] == nums[j - 1]) j--;//去重
                    j--;
                }else {
//                    List<Integer> result = new ArrayList<>();
//                    result.add(nums[k]);
//                    result.add(nums[i]);
//                    result.add(nums[j]);
//                    resultList.add(result);
                    resultList.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    while(i < j && nums[i] == nums[i + 1]) i++;//去重
                    i++;
                    while(i < j && nums[j] == nums[j - 1]) j--;//去重
                    j--;
                }
            }
        }
        return resultList;
    }

}
