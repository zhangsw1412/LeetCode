package leetcode.medium;

/**
 * Created by zhangsw on 2018/3/10.
 */
public class MaximumProductSubarray
{
	class Solution
	{
		public int maxProduct(int A[])
		{
			// store the result that is the max we have found so far
			int r = A[0];

			// imax/imin stores the max/min product of
			// subarray that ends with the current number A[i]
			for (int i = 1, imax = r, imin = r; i < A.length; i++)
			{
				// multiplied by a negative makes big number smaller, small number bigger
				// so we redefine the extremums by swapping them
				if (A[i] < 0)
				{
					int temp = imax;
					imax = imin;
					imin = temp;
				}

				// max/min product for the current number is either the current number itself
				// or the max/min by the previous number times the current one
				imax = Math.max(A[i], imax * A[i]);
				imin = Math.min(A[i], imin * A[i]);

				// the newly computed max value is a candidate for our global result
				r = Math.max(r, imax);
			}
			return r;
		}

		/*
		public int maxProduct(int[] A)
		{
			if (A == null || A.length == 0)
			{
				return 0;
			}
			int max = A[0], min = A[0], result = A[0];
			for (int i = 1; i < A.length; i++)
			{
				int temp = max;
				max = Math.max(Math.max(max * A[i], min * A[i]), A[i]);
				min = Math.min(Math.min(temp * A[i], min * A[i]), A[i]);
				if (max > result)
				{
					result = max;
				}
			}
			return result;
		}
		*/
	}
}
