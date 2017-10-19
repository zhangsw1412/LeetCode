package leetcode.easy;

/**
 * Created by zhangsw on 2017/10/19.
 */
public class ExcelSheetColumnNumber
{
	class Solution
	{
		public int titleToNumber(String s)
		{
			int result = 0;
			char[] ch = s.toCharArray();
			for (int i = 0; i < ch.length; ++i)
			{
				result = result * 26 + ch[i] - 'A' + 1;
			}
			return result;
		}
	}
}
