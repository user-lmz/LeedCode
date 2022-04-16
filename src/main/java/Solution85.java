import java.util.Deque;
import java.util.LinkedList;

public class Solution85 {
    public static int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0)
            return 0;
        int n = matrix[0].length;
        int[][] left = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1')
                    left[i][j] = (j==0 ? 0: left[i][j-1])+1;
            }
        }
        int ret = 0;

        for (int j = 0; j < n; j++) {
            Deque<Integer> stack = new LinkedList<>();
            int[] up = new int[m];
            int[] down = new int[m];
            for (int i = 0; i < m; i++) {
                if (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                    stack.pop();
                }
                up[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }
            stack.clear();
            for (int i = m-1; i >= 0; i--) {
                if (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                    stack.pop();
                }
                down[i] = stack.isEmpty() ? m : stack.peek();
                stack.push(i);
            }
            for (int i = 0; i < m; i++) {
                ret = Math.max(ret, (down[i]- up[i] - 1)*left[i][j]);
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        char[][] chs =
            {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
            };
        System.out.println(maximalRectangle(chs));
    }
}
