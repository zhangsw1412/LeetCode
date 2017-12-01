package leetcode.easy;

/**
 * Created by zhangsw on 2017/12/1.
 */
public class RangeAddition_II
{
	class Solution
	{
		public int maxCount(int m, int n, int[][] a)
		{
			int h = m, w = n;
			for (int[] i : a)
			{
				h = Math.min(h, i[0]);
				w = Math.min(w, i[1]);
			}
			return h * w;
		}
	}
}
