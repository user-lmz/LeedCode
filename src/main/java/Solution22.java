import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    private void backtrack(List<String> ans, StringBuilder cur, int left, int right, int n) {
        if (cur.length() == n * 2) {
            ans.add(cur.toString());
        }
        if (left < n) {
            cur.append('(');
            backtrack(ans, cur, left + 1, right, n);
            cur.deleteCharAt(cur.length() - 1);

        }
        if (right < left) {
            cur.append(')');
            backtrack(ans, cur, left, right + 1, n);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    @Test
    public void test() {
        System.out.println(generateParenthesis(3));
    }
}
