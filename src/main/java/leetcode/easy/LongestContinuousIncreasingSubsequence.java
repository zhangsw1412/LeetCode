package leetcode.easy;

/**
 * Created by zhangsw on 2017/12/7.
 */
public class LongestContinuousIncreasingSubsequence
{
	class Solution
	{
		public int findLengthOfLCIS(int[] a)
		{
			int length = 0;
			if (a != null && a.length != 0)
			{
				int counter = 1;
				for (int i = 1; i < a.length; i++)
				{
					if (a[i] > a[i - 1])
					{
						++counter;
					}
					else
					{
						length = Math.max(length, counter);
						counter = 1;
					}
				}
				length = Math.max(length, counter);
			}
			return length;
		}

		//简洁版
		/*
		public int findLengthOfLCIS(int[] a)
		{
			int mx = 0, len = 0;
			for (int i = 0; i < a.length; i++)
			{
				if (i == 0 || a[i] <= a[i - 1])
				{
					len = 0;
				}
				mx = Math.max(mx, ++len);
			}
			return mx;
		}
		*/
	}
}
