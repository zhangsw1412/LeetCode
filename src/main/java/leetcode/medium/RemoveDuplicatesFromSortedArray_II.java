package leetcode.medium;

/**
 * Created by zhangsw on 2017/12/29.
 */
public class RemoveDuplicatesFromSortedArray_II
{
	class Solution
	{
		public int removeDuplicates(int[] a)
		{
			if (a == null || a.length == 0)
			{
				return 0;
			}
			int counter = 0;
			for (int pos = 0; pos < a.length; ++pos)
			{
				if (counter > 1 && a[counter - 1] == a[pos] && a[counter - 1] == a[counter - 2])
				{
					continue;
				}
				a[counter++] = a[pos];
			}
			return counter;
		}
	}
}
