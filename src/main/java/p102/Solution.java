package p102;

import org.junit.Test;

import java.util.*;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; i++) {
                TreeNode node = queue.poll();
                assert node != null;
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }
    public List<TreeNode> createTree(List<Integer> arr) {
        if (arr == null || arr.size() == 0) {
            System.out.println("数组为空");
        }
        List<TreeNode> nodeList = new ArrayList<>();
        for (int i = 0; i < Objects.requireNonNull(arr).size(); i++) {
            nodeList.add(new TreeNode(arr.get(i)));
        }
        int index = 0;
        while(index <= (arr.size() - 2) / 2) {
            if ((index*2+1) < arr.size() && arr.get(index*2+1) != null)
                nodeList.get(index).left = nodeList.get(index*2+1);
            if ((index*2+2) < arr.size() && arr.get(index*2+2) != null)
                nodeList.get(index).right = nodeList.get(index*2+2);
            index++;
        }
        return nodeList;
    }

    @Test
    public void test() {
        List<Integer> arrs = new ArrayList<>(Arrays.asList(3, 9, 20, null, null, 15, 7));
        List<TreeNode> nodeTree = createTree(arrs);
        TreeNode root = nodeTree.get(0);
        System.out.println(levelOrder(root));
    }
}
