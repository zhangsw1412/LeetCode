package leetcode.medium;

/**
 * Created by zhangsw on 2018/4/18.
 */
public class AdditiveNumber
{
	class Solution
	{
		/*
		解题的关键在于确定前两个数，只要确定了前两个数，后面的数可以依次计算出来，要么符合条件要么不符合条件。
		那么如何确定前两个数？
		首先分析如何确定第一个数，第一个数的最小的长度是1（只包含一个数字），最大的长度是（L-1）/2，其中L为字符串的长度，
		最大的长度一定小于总长度的一半，比如如果总长度是5，第一个数长度不能超过2，如果总长度是6，第一个数长度也不能超过2，所以最大的长度是（L-1）/2。
		再确定第二个数的范围，第二个数从第一个数后面开始，第三个数从第二个数后面开始，我们首先知道，第三个数肯定至少和第一个数与第二个数一样大，
		因为是和嘛，若第二个数从i开始到j-1结束，那么第三个数长度最大为L-j，这个长度一定大于等于第一个数和第二个数长度的较大者，即：L-j>=i && L-j>=j-i。
		确定了第二个数的范围之后问题就简单了，看看能不能构成加法序列，只要判断剩下的字串是不是以sum开头即可，然后递归判定
		 */

		//递归版
		public boolean isAdditiveNumber(String num)
		{
			int L = num.length();

			// choose the first number A
			for (int i = 1; i <= (L - 1) / 2; i++)
			{
				// A cannot start with a 0 if its length is more than 1
				if (num.charAt(0) == '0' && i >= 2)
				{
					break; //previous code: continue;
				}

				// choose the second number B
				for (int j = i + 1; L - j >= j - i && L - j >= i; j++)
				{
					// B cannot start with a 0 if its length is more than 1
					if (num.charAt(i) == '0' && j - i >= 2)
					{
						break; // previous: continue;
					}

					long num1 = Long.parseLong(num.substring(0, i)); // A
					long num2 = Long.parseLong(num.substring(i, j)); // B
					String substr = num.substring(j); // remaining string

					if (isAdditive(substr, num1, num2))
					{
						return true; // return true if passes isAdditive test
					}
					// else continue; // continue for loop if does not pass isAdditive test
				}
			}
			return false; // does not pass isAdditive test, thus is not additive
		}

		// Recursively checks if a string is additive
		boolean isAdditive(String str, long num1, long num2)
		{
			if (str.equals(""))
			{
				return true; // reaches the end of string means a yes
			}

			long sum = num1 + num2;
			String s = ((Long) sum).toString();
			if (!str.startsWith(s))
			{
				return false; // if string does not start with sum of num1 and num2, returns false
			}

			return isAdditive(str.substring(s.length()), num2, sum); // recursively checks the remaining string
		}

		//迭代版
		/*
		public boolean isAdditiveNumber(String num)
		{
			int n = num.length();
			for (int i = 1; i <= n / 2; ++i)
			{
				for (int j = 1; Math.max(j, i) <= n - i - j; ++j)
				{
					if (isValid(i, j, num))
					{
						return true;
					}
				}
			}
			return false;
		}

		private boolean isValid(int i, int j, String num)
		{
			if (num.charAt(0) == '0' && i > 1)
			{
				return false;
			}
			if (num.charAt(i) == '0' && j > 1)
			{
				return false;
			}
			String sum;
			Long x1 = Long.parseLong(num.substring(0, i));
			Long x2 = Long.parseLong(num.substring(i, i + j));
			for (int start = i + j; start != num.length(); start += sum.length())
			{
				x2 = x2 + x1;
				x1 = x2 - x1;
				sum = x2.toString();
				if (!num.startsWith(sum, start))
				{
					return false;
				}
			}
			return true;
		}
		*/
	}
}
