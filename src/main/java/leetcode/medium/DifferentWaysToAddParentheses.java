package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangsw on 2018/4/4.
 */
public class DifferentWaysToAddParentheses
{
	class Solution
	{
		/*
		采用分治算法，分治算法的基本思想是将一个规模为N的问题分解为K个规模较小的子问题，
		这些子问题相互独立且与原问题性质相同，求出子问题的解，就可得到原问题的解。
		那么针对本题，以操作符为分界，将字符串分解为较小的两个子字符串，然后依次对两个子字符串进行同样的划分，
		直到字符串中只含有数字。再根据操作符对两端的数字进行相应的运算
		 */
		public List<Integer> diffWaysToCompute(String input)
		{
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < input.length(); i++)
			{
				char c = input.charAt(i);
				if (c == '+' || c == '-' || c == '*')
				{
					List<Integer> left = diffWaysToCompute(input.substring(0, i));
					List<Integer> right = diffWaysToCompute(input.substring(i + 1, input.length()));
					for (Integer l : left)
					{
						for (Integer r : right)
						{
							switch (c)
							{
								case '+':
									list.add(l + r);
									break;
								case '-':
									list.add(l - r);
									break;
								case '*':
									list.add(l * r);
							}
						}
					}
				}

			}
			if (list.size() == 0)
			{
				list.add(Integer.valueOf(input));
			}
			return list;
		}
	}
}
