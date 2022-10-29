package p863;

import org.junit.Test;

import java.util.*;

public class BinaryTreeDistance {
    Map<Integer, TreeNode> parents = new HashMap<>();
    List<Integer> ans = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        findParents(root);
        findAns(target, null, 0, k);
        return ans;
    }

    public void findParents(TreeNode node) {
        if (node.left != null) {
            parents.put(node.left.val, node);
            findParents(node.left);
        }
        if (node.right != null) {
            parents.put(node.right.val, node);
            findParents(node.right); 
        }
    }

    public void findAns(TreeNode node, TreeNode from, int depth, int k) {
        if (node == null) {
            return;
        }
        if (depth == k) {
            ans.add(node.val);
            return;
        }
        if (node.left != from) {
            findAns(node.left, node, depth + 1, k);
        }
        if (node.right != from) {
            findAns(node.right, node, depth + 1, k);
        }
        if (parents.get(node.val) != from) {
            findAns(parents.get(node.val), node, depth + 1, k);
        }
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
        List<Integer> arrs = new ArrayList<>(Arrays.asList(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4));
        List<TreeNode> nodeTree = createTree(arrs);
        TreeNode target = nodeTree.get(1);
        TreeNode root = nodeTree.get(0);

        System.out.println(distanceK(root, target, 2));
    }
}
