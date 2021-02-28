public class DetectCycle_142 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 采用双指针法：快慢指针分别一次走两步或者一步，当快慢指针相遇时候快指针走的步数为慢指针的两倍
     * 假设头节点到环入口节点的长度为a（不包括入口节点），环的长度为b
     * 第一次相遇时快指针走的步数为f，慢指针走的步数为s
     * f = s + n * b; f = 2s; -> s = n * b; f = 2n * b;
     * 走到入口节点的步数为：k = a + nb -> 只要慢指针再走a步即可
     * 此时只需要把快指针置于首节点，然后快慢指针每轮走一步，直至相遇即可定位环的入口点
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            //第一次相遇
            if(fast == slow) {
                fast = head;
                while(slow != fast) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}
