import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int currThreeNums = nums[i] + nums[left] + nums[right];
                if (Math.abs(currThreeNums - target) < Math.abs(ans - target)) {
                    ans = currThreeNums;
                }
                if (currThreeNums == target) {
                    return target;
                } else if (currThreeNums < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return ans;
    }

    @Test
    public void test() {
        Assert.assertEquals(2, threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }
}
