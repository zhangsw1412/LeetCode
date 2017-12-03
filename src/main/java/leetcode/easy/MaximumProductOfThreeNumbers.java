package leetcode.easy;

import java.util.Arrays;

/**
 * Created by zhangsw on 2017/12/3.
 */
public class MaximumProductOfThreeNumbers
{
	class Solution
	{
		public int maximumProduct(int[] a)
		{
			Arrays.sort(a);
			return Math.max(a[0] * a[1] * a[a.length - 1], a[a.length - 1] * a[a.length - 2] * a[a.length - 3]);
		}
	}
}
