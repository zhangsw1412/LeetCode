package leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangsw on 2017/12/1.
 */
public class MinimumIndexSumOfTwoLists
{
	class Solution
	{
		public String[] findRestaurant(String[] a, String[] b)
		{
			Map<String, Integer> map = new HashMap<>();
			int min = Integer.MAX_VALUE;
			List<String> list = new ArrayList<>();
			for (int i = 0; i < a.length; i++)
			{
				map.put(a[i], i);
			}
			for (int i = 0; i < b.length; i++)
			{
				if (map.containsKey(b[i]))
				{
					if (min >= (i + map.get(b[i])))
					{
						if (min > (i + map.get(b[i])))
						{
							min = i + map.get(b[i]);
							list.clear();
						}
						list.add(b[i]);
					}
				}
			}
			return list.toArray(new String[0]);
		}
	}
}
