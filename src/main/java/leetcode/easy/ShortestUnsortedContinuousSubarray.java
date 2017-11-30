package leetcode.easy;

import java.util.Arrays;

/**
 * Created by zhangsw on 2017/11/30.
 */
public class ShortestUnsortedContinuousSubarray
{
	class Solution
	{
		public int findUnsortedSubarray(int[] a)
		{
			int[] b = Arrays.copyOf(a, a.length);
			Arrays.sort(b);
			int start = 0, end = a.length - 1;
			while (start < a.length && a[start] == b[start])
			{
				++start;
			}
			while (end > 0 && a[end] == b[end])
			{
				--end;
			}
			return start < end ? end - start + 1 : 0;
		}
	}
}
