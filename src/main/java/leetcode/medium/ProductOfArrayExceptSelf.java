package leetcode.medium;

import java.util.Arrays;

/**
 * Created by zhangsw on 2018/4/2.
 */
public class ProductOfArrayExceptSelf
{
	class Solution
	{
		public int[] productExceptSelf(int[] a)
		{
			if (a == null || a.length == 0)
			{
				return null;
			}
			int[] b = new int[a.length];
			int temp = 1;
			b[0] = 1;
			for (int i = 1; i < a.length; i++)
			{
				temp *= a[i - 1];
				b[i] = temp;
			}
			temp = 1;
			for (int i = a.length - 2; i >= 0; i--)
			{
				temp *= a[i + 1];
				b[i] *= temp;
			}
			return b;
		}
	}
}
