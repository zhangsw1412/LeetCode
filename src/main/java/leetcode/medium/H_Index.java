package leetcode.medium;

import java.util.Arrays;

/**
 * Created by zhangsw on 2018/4/8.
 */
public class H_Index
{
	class Solution
	{
		public int hIndex(int[] c)
		{
			Arrays.sort(c);
			int i = 1;
			while (i <= c.length && c[c.length - i] >= i)
			{
				++i;
			}
			return --i;
		}

		//桶排序版
		/*
		public int hIndex(int[] citations)
		{
			int n = citations.length;
			int[] buckets = new int[n + 1];
			for (int c : citations)
			{
				if (c >= n)
				{
					buckets[n]++;
				}
				else
				{
					buckets[c]++;
				}
			}
			int count = 0;
			for (int i = n; i >= 0; i--)
			{
				count += buckets[i];
				if (count >= i)
				{
					return i;
				}
			}
			return 0;
		}
		*/
	}
}
