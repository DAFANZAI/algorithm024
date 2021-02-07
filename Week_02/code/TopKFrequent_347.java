import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent_347 {
    /**
     * 最小堆解法：1、用字典统计每个元素出现的频率
     *           2、定义比较器用PirorityQueue维护一个k个元素的最小堆
     *           3、将最小堆的元素输出
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        //用字典统计数组中每个元素出现的频率
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            if(map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            }else{
                map.put(num, 1);
            }
        }
        //用pirorityqueue维护一个只有k个元素的最小堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });
        for(int key : map.keySet()) {
            if(queue.size() < k) {
                queue.add(key);
            }else if(map.get(key) > map.get(queue.peek())){
                queue.poll();
                queue.add(key);
            }
        }
        int[] result = new int[k];
        for(int i = 0; i < k; i++) {
            result[i] = queue.poll();
        }
        return result;
    }
}
