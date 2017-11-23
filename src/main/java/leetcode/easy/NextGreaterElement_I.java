package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangsw on 2017/11/23.
 */
public class NextGreaterElement_I
{
	class Solution
	{
		public int[] nextGreaterElement(int[] a, int[] b)
		{
			List<Integer> list = new ArrayList<>();
			int pos;
			for (int i : a)
			{
				pos = -1;
				for (int j = 0; j < b.length; ++j)
				{
					if (b[j] == i)
					{
						pos = j;
					}
				}
				while (pos < b.length && b[pos] <= i)
				{
					++pos;
				}
				list.add((pos == b.length) ? -1 : b[pos]);
			}
			int[] result = new int[list.size()];
			pos = 0;
			for (Integer i : list)
			{
				result[pos++] = i;
			}
			return result;
		}
	}
}
