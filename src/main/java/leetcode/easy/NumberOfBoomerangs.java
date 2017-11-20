package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangsw on 2017/11/20.
 */
public class NumberOfBoomerangs
{
	class Solution
	{
		public int numberOfBoomerangs(int[][] a)
		{
			Map<Integer, Integer> map;
			int x, y, distance, result = 0;
			Integer temp;
			for (int i = 0; i < a.length; ++i)
			{
				map = new HashMap<>();
				for (int j = 0; j < a.length; ++j)
				{
					x = a[i][0] - a[j][0];
					y = a[i][1] - a[j][1];
					distance = x * x + y * y;
					if ((temp = map.putIfAbsent(distance, 1)) != null)
					{
						map.put(distance, temp + 1);
					}
				}
				for (Integer v : map.values())
				{
					result += v * (v - 1);
				}
			}
			return result;
		}
	}
}
