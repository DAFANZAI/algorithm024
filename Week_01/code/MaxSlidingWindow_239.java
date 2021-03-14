import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxSlidingWindow_239 {
    /**
     * 优先队列解法：对于求一系列数中的最大值，很容易想到的数据结构是优先队列
     * 1、初始将前k个元素放入优先队列
     * 2、滑动窗口每向右移动一次就把新的元素加入优先队列
     * 3、判断优先队列队首元素是否在滑动窗口中，如果不再就出队
     * 为了方便判断队首元素与滑动窗口位置关系，可以在优先队列中存储二元组
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        /*
        优先队列compare函数说明：
        PriorityQueue默认是按照最小堆排序的
        compare返回-1（负数）（o1排到队首）->o1比o2小（最小堆）
                                       ->o1比o2大（最大堆）
        compare返回1（正数）（o1排到队尾）->o1比o2大（最小堆）
                                      ->o1比o2小（大根堆）
        compare返回0->o1=o2
         */
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o2[0] - o1[0];
            }
        });
        //初始化优先队列
        int n = nums.length;
        for(int i = 0; i < k; i++) {
            pq.add(new int[]{nums[i], i});
        }
        int[] result = new int[n - k + 1];
        result[0] = pq.peek()[0];
        for(int i = k; i < n; i++) {
            pq.add(new int[]{nums[i], i});
            while(pq.peek()[1] < i - k + 1) {
                pq.poll();
            }
            result[i - k + 1] = pq.peek()[0];
        }
        return result;
    }
}
