package leetcode.medium;

import java.util.Arrays;

/**
 * Created by zhangsw on 2017/12/12.
 */
public class ZigZagConversion
{
	class Solution
	{
		//直接法
		public String convert(String s, int nRows)
		{
			int len = s.length();
			if (len == 0 || nRows <= 1)
			{
				return s;
			}

			String[] ans = new String[nRows];
			Arrays.fill(ans, "");
			int row = 0, delta = 1;
			for (int i = 0; i < len; i++)
			{
				ans[row] += s.charAt(i);
				row += delta;
				if (row >= nRows)
				{
					row = nRows - 2;
					delta = -1;
				}
				if (row < 0)
				{
					row = 1;
					delta = 1;
				}
			}

			String ret = "";
			for (int i = 0; i < nRows; i++)
			{
				ret += ans[i];
			}
			return ret;
		}

		//周期法
		/*
		public String convert(String s, int nRows)
		{
			int len = s.length();
			if (len == 0 || nRows < 2)
			{
				return s;
			}

			String ret = "";
			int lag = 2 * nRows - 2; //循环周期
			for (int i = 0; i < nRows; i++)
			{
				for (int j = i; j < len; j += lag)
				{
					ret += s.charAt(j);
					//非首行和末行时还要加一个
					if (i > 0 && i < nRows - 1)
					{
						int t = j + lag - 2 * i;
						if (t < len)
						{
							ret += s.charAt(t);
						}
					}
				}
			}
			return ret;
		}
		*/
	}
}
