package leetcode.easy;

/**
 * Created by zhangsw on 2017/11/23.
 */
public class MaxConsecutiveOnes
{
	class Solution
	{
		public int findMaxConsecutiveOnes(int[] a)
		{
			int max = 0, current = 0;
			for (int i : a)
			{
				if (i == 1)
				{
					++current;
				}
				else
				{
					max = (current > max) ? current : max;
					current = 0;
				}
			}
			return (current > max) ? current : max;
		}
	}
}
