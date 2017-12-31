package leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhangsw on 2017/12/31.
 */
public class GrayCode
{
	class Solution
	{
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
	}
}
