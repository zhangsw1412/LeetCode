package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangsw on 2018/3/29.
 */
public class SummaryRanges
{
	class Solution
	{
		public List<String> summaryRanges(int[] a)
		{
			List<String> list = new ArrayList<>();
			if (a == null || a.length == 0)
			{
				return list;
			}
			int start;
			for (int i = 0; i < a.length; i++)
			{
				start = i;
				while (i < a.length - 1 && a[i + 1] == a[i] + 1)
				{
					++i;
				}
				list.add(a[start] + ((start == i) ? "" : ("->" + a[i])));
			}
			return list;
		}
	}
}
