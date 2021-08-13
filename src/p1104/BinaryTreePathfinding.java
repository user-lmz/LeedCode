package p1104;

import org.junit.Test;

import java.util.*;

public class BinaryTreePathfinding {
    public List<Integer> pathInZigZagTree(int label) {
        int row = 1, rowStart = 1;
        while (rowStart * 2 <= label) {
            row++;
            rowStart *= 2;
        }
        if (row % 2 == 0) {
            label = getReverse(label, row);
        }
        List<Integer> path = new ArrayList<>();
        while (row > 0) {
            if(row % 2 == 0) {
                path.add(getReverse(label, row));
            } else {
                path.add(label);
            }
            row--;
            label >>= 1;
        }
        Collections.reverse(path);
        return path;
    }

    private int getReverse(int label, int row) {
        return (1 << row - 1) + (1 << row) - 1 - label;
    }

    @Test
    public void test() {
        List<Integer> lists = pathInZigZagTree(11);
        //System.out.println(Arrays.toString(lists.toArray()));
        System.out.println(lists);
    }
}
