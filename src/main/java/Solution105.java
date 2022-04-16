import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution105 {
    @Test
    public void test() {
        TreeNode node  = buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        postOrder(node);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(map, 0, preorder.length-1, preorder);
    }

    int rootIndex = 0;
    private TreeNode buildTree(Map<Integer, Integer> map, int left, int right, int[] preorder) {
        if (left <= right) {
            int rootValue = preorder[rootIndex];
            rootIndex++;
            TreeNode root = new TreeNode(rootValue);
            root.left = buildTree(map, left, map.get(rootValue)-1, preorder);
            root.right = buildTree(map, map.get(rootValue)+1, right, preorder);
            return root;
        } else
            return null;

    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public void postOrder(TreeNode root) {
        if (root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }
}
