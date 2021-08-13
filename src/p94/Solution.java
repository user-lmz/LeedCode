package p94;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Solution {
    List<Integer> lists = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root.left != null)
            inorderTraversal(root.left);
        lists.add(root.val);
        if (root.right != null)
            inorderTraversal(root.right);
        return lists;
    }

    public List<TreeNode> createTreeNode(List<Integer> nodes) {
        if (nodes == null || nodes.size() == 0)
            System.out.println("数组为空");
        List<TreeNode> nodeList = new ArrayList<>();
        for (int i = 0; i < Objects.requireNonNull(nodes).size(); i++) {
            nodeList.add(new TreeNode(nodes.get(i)));
        }
        int index = 0;
        while (index <= (nodes.size() - 2) / 2) {
            if ((index * 2 + 1) < nodes.size() && nodes.get(index * 2 + 1) != null) {
                nodeList.get(index).left = nodeList.get(index * 2 + 1);
            }
            if ((index * 2 + 2) < nodes.size() && nodes.get(index * 2 + 2) != null) {
                nodeList.get(index).right = nodeList.get(index * 2 + 2);
            }
            index++;
        }
        return nodeList;
    }

    @Test
    public void main() {
        TreeNode root;
        root = createTreeNode(new ArrayList<>(Arrays.asList(1, null, 2, null, null, 3))).get(0);
        System.out.println(inorderTraversal(root));
    }
}
