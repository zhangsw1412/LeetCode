package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by zhangsw on 2018/7/5.
 */
public class LargestDivisibleSubset
{
    class Solution
    {
        public List<Integer> largestDivisibleSubset(int[] nums)
        {
            if (nums.length == 0)
            {
                return Collections.emptyList();
            }
            Arrays.sort(nums);
            int[] dp = new int[nums.length], pre = new int[nums.length];
            Arrays.fill(dp, 1);
            Arrays.fill(pre, -1);
            int max = 1, maxIndex = 0;

            for (int i = 1; i < nums.length; i++)
            {
                for (int j = 0; j < i; j++)
                {
                    if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1)
                    {
                        dp[i] = dp[j] + 1;
                        pre[i] = j;
                    }
                    if (dp[i] > max)
                    {
                        max = dp[i];
                        maxIndex = i;
                    }
                }
            }

            List<Integer> result = new ArrayList<>();
            for (int i = maxIndex; i >= 0; )
            {
                result.add(nums[i]);
                i = pre[i];
            }

            return result;
        }
    }
}
