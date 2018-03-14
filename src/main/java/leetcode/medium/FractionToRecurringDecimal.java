package leetcode.medium;

import java.util.HashMap;

/**
 * Created by zhangsw on 2018/3/14.
 */
public class FractionToRecurringDecimal
{
	class Solution
	{
		//需要考虑的边界条件有负数、溢出
		public String fractionToDecimal(int numerator, int denominator)
		{
			if (numerator == 0)
			{
				return "0";
			}
			StringBuilder res = new StringBuilder();
			// "+" or "-"
			res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
			long num = Math.abs((long) numerator);
			long den = Math.abs((long) denominator);

			// integral part
			res.append(num / den);
			num %= den;
			if (num == 0)
			{
				return res.toString();
			}

			// fractional part
			res.append(".");
			HashMap<Long, Integer> map = new HashMap<>();
			map.put(num, res.length());
			while (num != 0)
			{
				num *= 10;
				res.append(num / den);
				num %= den;
				if (map.containsKey(num))
				{
					int index = map.get(num);
					res.insert(index, "(");
					res.append(")");
					break;
				}
				else
				{
					map.put(num, res.length());
				}
			}
			return res.toString();
		}
	}
}
