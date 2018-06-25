package leetcode.medium;

import java.util.Arrays;

/**
 * Created by zhangsw on 2018/6/25.
 */
public class WiggleSort_II
{
    class Solution
    {
        public void wiggleSort(int[] nums)
        {
            int[] temp = Arrays.copyOf(nums, nums.length);
            Arrays.sort(temp);
            int small = (temp.length - 1) / 2, large = temp.length - 1;
            for (int i = 0; i < nums.length; i++)
            {
                nums[i] = (i & 1) == 0 ? temp[small--] : temp[large--];
            }
        }
    }
}
