public class LowestCommonAncestor_236 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 后序遍历解法DFS：
     * 1、二叉树类型的题目一般会采用递归的解法，因为树这种数据结构具有天然的递归结构
     * 2、后序遍历二叉树寻找符合题目要求的节点
     *
     * 最近公共祖先需要满足以下条件：
     * p和q分列root的左右子树中
     * root等于p或者q其中一个，另一个位于root左子树或者右子树中
     *
     * 为什么要用后序遍历？
     * 根据最近公共祖先判断条件，跟节点是否满足条件是需要先判断左右孩子节点
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //递归终止条件
        if(root == null || root == p || root == q)
            return root;
        //递归调用
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //返回结果处理
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }
}
