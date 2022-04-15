import org.junit.Test;

public class solution1047 {
    public String removeDuplicates(String s) {
        StringBuilder bf = new StringBuilder();
        int top = -1;
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (top >= 0 && bf.charAt(top) == ch) {
                bf.deleteCharAt(top);
                --top;
            } else {
                bf.append(ch);
                ++top;
            }
        }
        return bf.toString();
    }

    @Test
    public void test1() {
        System.out.println(removeDuplicates("abbaca"));
    }
}
