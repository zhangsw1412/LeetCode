package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangsw on 2017/11/13.
 */
public class BinaryWatch
{
	class Solution
	{
		//简洁版
		public List<String> readBinaryWatch(int num)
		{
			ArrayList<String> result = new ArrayList<>();
			for (int i = 0; i < 12; i++)
			{
				for (int j = 0; j < 60; j++)
				{
					if (Integer.bitCount(i) + Integer.bitCount(j) == num)
					{
						result.add(String.format("%d:%02d", i, j));
					}
				}
			}
			return result;
		}
		//自己的版本
		/*
		public List<String> readBinaryWatch(int n)
		{
			List<String> result = new ArrayList<>();
			List<Integer> minute, hour;
			int h, m, counter, temp;
			for (h = 0; h <= 4; ++h)
			{
				m = n - h;
				if (m >= 0 && m <= 6)
				{
					counter = 0;
					hour = new ArrayList<>();
					minute = new ArrayList<>();
					while (counter < 12)
					{
						temp = count1Bits(counter);
						if (temp == h)
						{
							hour.add(counter);
						}
						counter++;
					}
					counter = 0;
					while (counter < 60)
					{
						temp = count1Bits(counter);
						if (temp == m)
						{
							minute.add(counter);
						}
						counter++;
					}
					for (Integer _h : hour)
					{
						for (Integer _m : minute)
						{
							result.add(_h.toString() + ":" + (_m < 10 ? "0" + _m : _m));
						}
					}
				}
			}
			return result;
		}

		private int count1Bits(int a)
		{
			int result = 0;
			while (a != 0)
			{
				a &= (a - 1);
				++result;
			}
			return result;
		}
		*/
	}
}
