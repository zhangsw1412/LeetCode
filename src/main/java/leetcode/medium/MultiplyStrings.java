package leetcode.medium;

/**
 * Created by zhangsw on 2017/12/20.
 */
public class MultiplyStrings
{
	class Solution
	{
		public String multiply(String num1, String num2)
		{
			if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0)
			{
				return "";
			}
			if (num1.charAt(0) == '0')
			{
				return "0";
			}
			if (num2.charAt(0) == '0')
			{
				return "0";
			}
			StringBuilder res = new StringBuilder();
			int num = 0;
			for (int i = num1.length() + num2.length(); i > 0; i--)
			{
				for (int j = Math.min(i - 1, num1.length()); j > 0; j--)
				{
					if (i - j <= num2.length())
					{
						num += (num1.charAt(j - 1) - '0') * (num2.charAt(i - 1 - j) - '0');
					}
				}
				if (i != 1 || num > 0)
				{
					res.append(num % 10);
				}
				num = num / 10;
			}
			return res.reverse().toString();
		}

		//直观解法
		/*
		public String multiply(String num1, String num2)
		{
			int n1 = num1.length(), n2 = num2.length();
			int[] products = new int[n1 + n2];
			for (int i = n1 - 1; i >= 0; i--)
			{
				for (int j = n2 - 1; j >= 0; j--)
				{
					int d1 = num1.charAt(i) - '0';
					int d2 = num2.charAt(j) - '0';
					products[i + j + 1] += d1 * d2;
				}
			}
			int carry = 0;
			for (int i = products.length - 1; i >= 0; i--)
			{
				int tmp = (products[i] + carry) % 10;
				carry = (products[i] + carry) / 10;
				products[i] = tmp;
			}
			StringBuilder sb = new StringBuilder();
			for (int num : products)
			{
				sb.append(num);
			}
			while (sb.length() != 0 && sb.charAt(0) == '0')
			{
				sb.deleteCharAt(0);
			}
			return sb.length() == 0 ? "0" : sb.toString();
		}
		*/
	}
}
