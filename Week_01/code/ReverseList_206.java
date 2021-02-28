public class ReverseList_206 {
    //定义一个单向链表
    class ListNode {
        int val;
        ListNode next;
        ListNode() {};
        ListNode(int val) {
            val = this.val;
        }
        ListNode(int val, ListNode nextNode) {
            this.val = val;
            this.next = nextNode;
        }
    }

    /**
     * 递归法求解：
     * 链表具有天然的递归结构
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
//        if(head == null) return null;
//        ListNode node = reverseList1(head.next);
//        //添加head节点到链表尾部
//        if(node == null) return head;
//        ListNode listNode = node;
//        while(listNode.next != null) listNode = listNode.next;
//        listNode.next = head;
//        head.next = null;
//        return node;
        //简化版写法
        if(head == null || head.next == null) return head;
        ListNode node = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    /**
     * 迭代法求解：
     * 采用双指针法求解：定义一个当前指针和一个前指针，依次进行链表方向反转
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        ListNode curNode = head, preNode = null;
        while(curNode != null) {
            ListNode tempNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = tempNode;
        }
        return preNode;
    }
}
