package leetcode.medium;

/**
 * Created by zhangsw on 2018/6/29.
 */
public class IncreasingTripletSubsequence
{
    class Solution
    {
        public boolean increasingTriplet(int[] nums)
        {
            if (nums.length < 3)
            {
                return false;
            }
            int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
            for (int num : nums)
            {
                if (num < min)
                {
                    min = num;
                }
                else if (num < secondMin)
                {
                    secondMin = num;
                }
                else
                {
                    return true;
                }
            }
            return false;
        }
    }
}
