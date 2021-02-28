public class ReverseKGroup_25 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 递归解法
     * 1、找到待翻转的k个节点（第k个节点的下个节点记为tail），如果剩余数量小于k，直接返回头节点
     * 2、执行翻转操作，记录新的头节点
     * 3、对剩余节点执行递归，返回头节点
     * 4、head指针（即第二步翻转后的尾节点）指向递归返回的头节点
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 0) return head;
        //找待翻转的k个节点
        ListNode tail = head;
        for(int i = 0; i < k; i++){
            tail = tail.next;
            if(tail == null && i != k - 1){
                return head;
            }
        }
        //执行链表翻转
        ListNode newHead = reverse(head, tail);
        head.next = reverseKGroup(tail, k);
        return newHead;
    }

    public ListNode reverse(ListNode head, ListNode tail) {
        if(head == null || head.next == tail) return head;
        ListNode newHead = reverse(head.next, tail);
        head.next.next = head;
        head.next = tail;
        return newHead;
    }
}
