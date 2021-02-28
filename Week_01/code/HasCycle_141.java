public class HasCycle_141 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 经典快慢指针法求解
     */
    public boolean hasCycle(ListNode head) {
        ListNode fastNode = head;
        ListNode slowNode = head;
        while(fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
            if(fastNode == slowNode) {
                return true;
            }
        }
        return false;
    }
}
