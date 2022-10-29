package p100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (!Objects.equals(p.val, q.val)) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

    public List<TreeNode> createTrees(List<Integer> args) {
        List<TreeNode> nodeTrees = new ArrayList<>();
        if (args == null || args.size() == 0) {
            System.out.println("数组为空");
        }
        for (int i = 0; i < Objects.requireNonNull(args).size(); i++) {
            nodeTrees.add(new TreeNode(args.get(i)));
        }
        int index = 0;
        while (index <= (args.size() - 2) / 2) {
            if ((index * 2 + 1) < args.size() && args.get(index * 2 + 1) != null) {
                nodeTrees.get(index).left = nodeTrees.get(index * 2 + 1);
            }
            if ((index * 2 + 2) < args.size() && args.get(index * 2 + 2) != null) {
                nodeTrees.get(index).right = nodeTrees.get(index * 2 + 2);
            }
            index++;
        }
        return nodeTrees;
    }

    @Test
    public void test() {
        List<TreeNode> tree1 = createTrees(new ArrayList<>(Arrays.asList(1, 2, 3)));
        List<TreeNode> tree2 = createTrees(new ArrayList<>(Arrays.asList(1, 2, 3)));
        System.out.println(isSameTree(tree1.get(0), tree2.get(0)));
    }
}
