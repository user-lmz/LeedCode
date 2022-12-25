package offer_special_training;

import org.junit.Assert;
import org.junit.Test;

public class Solution1_1 {
    public int divide(int a, int b) {
        if (a == 0x80000000 && b == -1) {
            return Integer.MAX_VALUE;
        }
        int negative = 2;
        if (a > 0) {
            negative--;
            a = -a;
        }
        if (b > 0) {
            negative--;
            b = -b;
        }
        int result = divideCode(a, b);
        return negative == 1 ? -result : result;
    }

    private int divideCode(int dividend, int divisor) {
        int result = 0;
        while (dividend <= divisor) {
            int value = divisor;
            int quotient = 1;
            while (value >= 0xc0000000 && dividend <= value + value) {
                quotient += quotient;
                value += value;
            }
            result += quotient;
            dividend -= value;
        }
        return result;
    }

    @Test
    public void test() {
        Assert.assertEquals(2, divide(2, 5));
    }
}
