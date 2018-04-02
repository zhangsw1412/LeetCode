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

		//递归版，没看懂
		/*
		public int[] productExceptSelfRev(int[] nums)
		{
			multiply(nums, 1, 0, nums.length);

			return nums;
		}

		private int multiply(int[] a, int fwdProduct, int indx, int N)
		{
			int revProduct = 1;
			if (indx < N)
			{
				revProduct = multiply(a, fwdProduct * a[indx], indx + 1, N);
				int cur = a[indx];
				a[indx] = fwdProduct * revProduct;
				revProduct *= cur;
			}
			return revProduct;
		}
		*/
	}
}
