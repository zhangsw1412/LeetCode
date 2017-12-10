package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangsw on 2017/12/10.
 */
public class SelfDividingNumbers
{
	class Solution
	{
		public List<Integer> selfDividingNumbers(int left, int right)
		{
			List<Integer> list = new ArrayList<>();
			boolean flag;
			for (int i = left; i <= right; i++)
			{
				flag = true;
				for (char c : String.valueOf(i).toCharArray())
				{
					if (c == '0' || i % (c - '0') != 0)
					{
						flag = false;
						break;
					}
				}
				if (flag)
				{
					list.add(i);
				}
			}
			return list;
		}
	}
}
