public class SwapPairs_24 {
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
     * 递归解法：
     * 1、定义两个指针head和next分别指向前两个元素，对后面的元素递归
     * 2、交换head和next两个元素和递归返回的元素相连
     * @param head
     * @return
     */
    public ListNode swapPairs1(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode nextNode = head.next;
        head.next = swapPairs1(nextNode.next);
        nextNode.next = head;
        return nextNode;
    }

    /**
     * 迭代法求解：需要定义三个指针
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode next = head.next;
        ListNode pre = new ListNode();
        ListNode preNode = pre;
        pre.next = head;
        preNode.next = head;
        while(head != null && next != null) {
            ListNode temp = next.next;
            next.next = head;
            pre.next = next;
            head.next = temp;
            pre = head;
            head = temp;
            if(head != null) next = head.next;
        }
        return preNode.next;
    }
}
