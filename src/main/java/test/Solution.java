package test;

import org.junit.Test;

import java.util.*;

class BinaryTreeNode {
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    private BinaryTreeNode lastTreeNode;
    private int maxLayer = Integer.MIN_VALUE;
    public BinaryTreeNode getTree(int[][] ops) {
        BinaryTreeNode root = new BinaryTreeNode(-1);
        List<List<BinaryTreeNode>> listTreeNode = new ArrayList<>();
        for (int[] op : ops) {
            maxLayer = Math.max(maxLayer, op[0] + 1);
        }
        for (int i = 0; i <= maxLayer; i++) {
            listTreeNode.add(new ArrayList<>());
        }
        listTreeNode.get(0).add(root);
        int index = 0;
        for (int[] op : ops) {
            int x = op[0];
            int y = op[1];
            BinaryTreeNode curTreeNode = listTreeNode.get(x).get(y);
            if (curTreeNode.left == null) {
                curTreeNode.left = new BinaryTreeNode(index);
                listTreeNode.get(x + 1).add(curTreeNode.left);
            } else if (curTreeNode.right == null) {
                curTreeNode.right = new BinaryTreeNode(index);
                listTreeNode.get(x + 1).add(curTreeNode.right);
            } else {
                index++;
            }
            index++;
        }
        if (listTreeNode.get(listTreeNode.size() - 1).size() - 1 >= 0) {
            lastTreeNode = listTreeNode.get(listTreeNode.size() - 1)
                    .get(listTreeNode.get(listTreeNode.size() - 1).size() - 1);
            System.out.println(lastTreeNode.val);
        }

        return listTreeNode.get(0).get(0);
    }
    @Test
    public void test() {
        BinaryTreeNode binaryTreeNode = getTree(new int[][]{{0, 0}, {0, 0}, {1, 0}, {1, 1}, {1, 1}});
        levelTravel(binaryTreeNode);
        System.out.println();
        BinaryTreeNode binaryTreeNode1 =
                getTree(new int[][]{{0, 0}, {0, 0}, {1, 0}, {1, 1}, {1, 1}, {1, 1}, {2, 1}, {1, 0}});
        levelTravel(binaryTreeNode1);
    }
    private void levelTravel(BinaryTreeNode root) {
        if (root == null)
            return;
        Queue<BinaryTreeNode> q = new ArrayDeque<>();
        q.add(root);
        BinaryTreeNode nullNode = new BinaryTreeNode(-2);
        BinaryTreeNode cur;
        while (!q.isEmpty()) {
            cur = q.poll();
            if (cur != null) {
                if (cur.val != -2) {
                    System.out.print(cur.val + " ");
                } else {
                    System.out.print("null ");
                }
                if (cur == lastTreeNode)
                    break;

                // if (cur.left != null) {
                //     q.add(cur.left);
                // } else {
                //     q.add(nullNode);
                // }
                //
                // if (cur.right != null) {
                //     q.add(cur.right);
                // } else {
                //     q.add(nullNode);
                // }
                q.add(Objects.requireNonNullElse(cur.left, nullNode));
                q.add(Objects.requireNonNullElse(cur.right, nullNode));

            }
        }
    }
}
