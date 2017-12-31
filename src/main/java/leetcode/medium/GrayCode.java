package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangsw on 2017/12/31.
 */
public class GrayCode
{
	class Solution
	{
		//迭代法
		public List<Integer> grayCode(int n)
		{
			List<Integer> rs = new ArrayList<Integer>();
			rs.add(0);
			for (int i = 0; i < n; i++)
			{
				int size = rs.size();
				for (int k = size - 1; k >= 0; k--)
				{
					rs.add(rs.get(k) | 1 << i);
				}
			}
			return rs;
		}
		/*
		public List<Integer> grayCode(int n)
		{
			//看不懂...
			List<Integer> result = new LinkedList<>();
			for (int i = 0; i < 1 << n; i++)
			{
				result.add(i ^ i >> 1);
			}
			return result;
		}
		*/
	}
}
