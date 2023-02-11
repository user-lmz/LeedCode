package test;

import org.junit.Test;

public class Test1 {
    @Test
    public void test() {
        // 97二进制1100001
        // 65二进制1000001
        System.out.println(65 | (1 << 5));
        System.out.println(97 | (1 << 5));
        System.out.println('A' | (1 << 5));
        System.out.println('a' | (1 << 5));

        System.out.println(1 | 0);
        System.out.println(1 | 1);
        System.out.println(0 | 0);
    }
}
