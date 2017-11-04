package leetcode.easy;

/**
 * Created by zhangsw on 2017/11/5.
 */
public class RangeSumQueryImmutable
{
	class NumArray
	{
		int[] sum;

		public NumArray(int[] a)
		{
			this.sum = new int[a.length + 1];
			for (int i = 0; i < a.length; ++i)
			{
				this.sum[i + 1] = this.sum[i] + a[i];
			}
		}

		public int sumRange(int i, int j)
		{
			return this.sum[j + 1] - this.sum[i];
		}
	}
}
