import java.util.Arrays;

public class BuildTree_105 {
    class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
   }

    /**
     * 递归解法：前序遍历的第一个节点就是根节点，以根节点为分界可从中序遍历结果中得到左右子树，
     *          然后再分别对左右子树进行递归
     * @param preorder
     * @param inorder
     * @return
     */
   public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0)
            return null;
        TreeNode root = new TreeNode(preorder[0]);
        for(int i = 0; i < inorder.length; i++) {
            //在前序遍历结果中寻找根节点的位置
            if(preorder[0] == inorder[i]) {
                root.left = buildTree(Arrays.copyOfRange(preorder, 1, i+1),
                        Arrays.copyOfRange(inorder, 0, i));
                root.right = buildTree(Arrays.copyOfRange(preorder, i+1, preorder.length),
                        Arrays.copyOfRange(inorder, i + 1, inorder.length));
            }
        }
        return root;
   }
}
