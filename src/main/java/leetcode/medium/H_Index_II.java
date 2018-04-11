package leetcode.medium;

/**
 * Created by zhangsw on 2018/4/11.
 */
public class H_Index_II
{
	class Solution
	{
		public int hIndex(int[] c)
		{
			int i = 1;
			while (i <= c.length && c[c.length - i] >= i)
			{
				++i;
			}
			return --i;
		}

		//二分法
		/*
		public int hIndex(int[] citations)
		{
			int len = citations.length;
			int lo = 0, hi = len - 1;
			while (lo <= hi)
			{
				int med = (hi + lo) / 2;
				if (citations[med] == len - med)
				{
					return len - med;
				}
				else if (citations[med] < len - med)
				{
					lo = med + 1;
				}
				else
				{
					//(citations[med] > len-med), med qualified as a hIndex,
					// but we have to continue to search for a higher one.
					hi = med - 1;
				}
			}
			return len - lo;
		}
		*/
	}
}
