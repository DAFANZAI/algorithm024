import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NtreePreorder_589 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /**
     * 递推解法： 1、首先定义递归终止条件，如果一个根节点为null，直接返回一个空的list；
     *          2、然后定义递推关系，先添加根节点的值，再依次从左到右添加孩子节点前序遍历的结果。
     * @param root
     * @return
     */
    public List<Integer> preorder1(Node root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        list.add(root.val);
        for(Node childNode : root.children) {
            list.addAll(preorder1(childNode));
        }
        return list;
    }

    /**
     * 栈解法：1、先压入根节点
     *        2、while stack != null : 取栈顶节点加入list，将孩子节点从右到左压入堆栈
     * @param root
     * @return
     */
    public List<Integer> preorder2(Node root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()) {
            Node node = stack.pop();
            list.add(node.val);
            for(int i = node.children.size() - 1; i >= 0; i--) {
                stack.push(node.children.get(i));
            }
        }
        return list;
    }

}
