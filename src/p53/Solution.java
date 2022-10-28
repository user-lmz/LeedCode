package p53;

import org.junit.Test;

public class Solution {
    public int maxSubArray(int[] nums) {
        int pre = 0, maxNum = nums[0];
        for (int num: nums) {
            pre = Math.max(pre+num, num);
            maxNum = Math.max(maxNum, pre);
        }
        return maxNum;
    }

    @Test
    public void test() {
        System.out.println(
                maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
