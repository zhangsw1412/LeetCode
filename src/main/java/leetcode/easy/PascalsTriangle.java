package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangsw on 2017/10/11.
 */
public class PascalsTriangle
{
	class Solution
	{
		public List<List<Integer>> generate(int n)
		{
			List<List<Integer>> list = new ArrayList<>();
			if (n > 0)
			{
				List<Integer> temp = new ArrayList<>(), pre;
				temp.add(1);
				list.add(temp);
				for (int i = 2; i <= n; ++i)
				{
					temp = new ArrayList<>();
					temp.add(1);
					pre = list.get(i - 2);
					for (int j = 1, count = pre.size(); j < count; ++j)
					{
						temp.add(pre.get(j - 1) + pre.get(j));
					}
					temp.add(1);
					list.add(temp);
				}
			}
			return list;
		}
	}
}
