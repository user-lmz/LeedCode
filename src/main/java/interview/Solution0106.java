package interview;

import org.junit.Test;
import java.util.Scanner;

public class Solution0106 {
    @Test
    public void test(){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            System.out.println(compressString(in.next()));
        }
    }
    public String compressString(String S) {
        if (S.length() == 0) { // 空串处理
            return S;
        }
        StringBuffer ans = new StringBuffer();
        int cnt = 1;
        char ch = S.charAt(0);
        for (int i = 1; i < S.length(); ++i) {
            if (ch == S.charAt(i)) {
                cnt++;
            } else {
                ans.append(ch);
                ans.append(cnt);
                ch = S.charAt(i);
                cnt = 1;
            }
        }
        ans.append(ch);
        ans.append(cnt);
        return ans.length() >= S.length() ? S : ans.toString();
    }
}
