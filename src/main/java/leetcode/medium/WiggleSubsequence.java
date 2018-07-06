package leetcode.medium;

import java.util.Arrays;

/**
 * Created by zhangsw on 2018/7/6.
 */
public class WiggleSubsequence
{
    class Solution
    {
        /*
        动态规划
        DP法，对于从index=0到当前位置index=i这段，用dp[i]表示最大的wiggle sequence长度，这个长度肯定是由前面某个位置+1得到的，
        而前面某个位置对应的差值数组中的元素可能为正，也可能为负，
        所以需要两组dp来记录，分别表示当前差值为正和当前差值为负所能取到的最大长度
        */
        public int wiggleMaxLength(int[] nums)
        {
            if (nums == null || nums.length == 0)
            {
                return 0;
            }
            int[] increase = new int[nums.length], decrease = new int[nums.length];
            Arrays.fill(increase, 1);
            Arrays.fill(decrease, 1);
            for (int i = 0; i < nums.length; i++)
            {
                for (int j = 0; j < i; j++)
                {
                    if (nums[i] > nums[j])
                    {
                        increase[i] = Math.max(increase[i], decrease[j] + 1);
                    }
                    else if (nums[i] < nums[j])
                    {
                        decrease[i] = Math.max(decrease[i], increase[j] + 1);
                    }
                }
            }
            return Math.max(increase[nums.length - 1], decrease[nums.length - 1]);
        }

        /*
        贪心法
        维护两个变量p和q，然后遍历数组，如果当前数字比前一个数字大，则p=q+1，
        如果比前一个数字小，则q=p+1，最后取p和q中的较大值跟n比较，取较小的那个
         */
        /*
        public int wiggleMaxLength(int[] nums)
        {
            if (nums == null || nums.length == 0)
            {
                return 0;
            }
            int increase = 1, decrease = 1;
            for (int i = 1; i < nums.length; i++)
            {
                if (nums[i] > nums[i - 1])
                {
                    increase = decrease + 1;
                }
                else if (nums[i] < nums[i - 1])
                {
                    decrease = increase + 1;
                }
            }
            return Math.min(nums.length, Math.max(increase, decrease));
        }
        */
    }
}
