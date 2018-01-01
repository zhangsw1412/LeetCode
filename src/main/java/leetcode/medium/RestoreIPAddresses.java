package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangsw on 2018/1/1.
 */
public class RestoreIPAddresses
{
	class Solution
	{
		//回溯法
		public List<String> restoreIpAddresses(String s)
		{
			List<String> solutions = new ArrayList<String>();
			restoreIp(s, solutions, 0, "", 0);
			return solutions;
		}

		private void restoreIp(String ip, List<String> solutions, int idx, String restored, int count)
		{
			if (count > 4)
			{
				return;
			}
			if (count == 4 && idx == ip.length())
			{
				solutions.add(restored);
			}

			for (int i = 1; i < 4; i++)
			{
				if (idx + i > ip.length())
				{
					break;
				}
				String s = ip.substring(idx, idx + i);
				if ((s.startsWith("0") && s.length() > 1) || (Integer.parseInt(s) >= 256))
				{
					continue;
				}
				restoreIp(ip, solutions, idx + i, restored + s + (count == 3 ? "" : "."), count + 1);
			}
		}
		//与下面的解法思路相似
		/*
		public List<String> restoreIpAddresses(String s)
		{
			List<String> res = new ArrayList<String>();
			int len = s.length();
			StringBuffer ip = new StringBuffer();
			for (int a = 1; a <= 3; a++)
			{
				for (int b = 1; b <= 3; b++)
				{
					for (int c = 1; c <= 3; c++)
					{
						int d = len - a - b - c;
						if (d > 0 && d <= 3 && a + b + c + d == s.length())
						{
							int A = Integer.parseInt(s.substring(0, a));
							int B = Integer.parseInt(s.substring(a, a + b));
							int C = Integer.parseInt(s.substring(a + b, a + b + c));
							int D = Integer.parseInt(s.substring(a + b + c));
							if (A <= 255 && B <= 255 && C <= 255 && D <= 255)
							{
								ip.append(A).append(".").append(B).append(".").append(C).append(".").append(D);
								if (ip.length() == len + 3)
								{
									res.add(ip.toString());
								}
								ip = new StringBuffer();
							}
						}
					}
				}
			}
			return res;
		}
		*/

		/*
		public List<String> restoreIpAddresses(String s)
		{
			List<String> res = new ArrayList<String>();
			int len = s.length();
			for (int i = 1; i < 4 && i < len - 2; i++)
			{
				for (int j = i + 1; j < i + 4 && j < len - 1; j++)
				{
					for (int k = j + 1; k < j + 4 && k < len; k++)
					{
						String s1 = s.substring(0, i), s2 = s.substring(i, j), s3 = s.substring(j, k), s4 = s
								.substring(k, len);
						if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4))
						{
							res.add(s1 + "." + s2 + "." + s3 + "." + s4);
						}
					}
				}
			}
			return res;
		}

		public boolean isValid(String s)
		{
			if (s.length() > 3 || s.length() == 0 || (s.charAt(0) == '0' && s.length() > 1) || Integer
					.parseInt(s) > 255)
			{
				return false;
			}
			return true;
		}
		*/
	}
}
