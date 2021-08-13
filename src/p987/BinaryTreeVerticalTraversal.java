package p987;

import org.junit.Test;

import java.util.*;

public class BinaryTreeVerticalTraversal {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> nodes = new ArrayList<>();
        dfs(root, 0, 0, nodes);
        Collections.sort(nodes, new Comparator<int[]>() {
            @Override
            public int compare(int[] tuple1, int[] tuple2) {
                if (tuple1[0] != tuple2[0]) {
                    return tuple1[0] - tuple2[0];
                } else if (tuple1[1] != tuple2[1]) {
                    return tuple1[1] - tuple2[1];
                } else {
                    return tuple1[2] - tuple2[2];
                }
            }
        });
        List<List<Integer>> ans = new ArrayList<>();
        int size = 0;
        int lastcol = Integer.MIN_VALUE;
        for (int[] tuple : nodes) {
            int col = tuple[0], row = tuple[1], value = tuple[2];
            if (col != lastcol) {
                lastcol = col;
                ans.add(new ArrayList<>());
                size++;
            }
            ans.get(size - 1).add(value);
        }
        return ans;
    }

    private void dfs(TreeNode node, int row, int col , List<int[]> nodes) {
        if (node == null) {
            return;
        }
        nodes.add(new int[]{col, row, node.val});
        dfs(node.left, row+1, col-1, nodes);
        dfs(node.right, row+1, col+1, nodes);
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
        TreeNode nodeTree = createTree(arrs).get(0);
        System.out.println(verticalTraversal(nodeTree));
    }
}
