package leetcode.easy;

/**
 * Created by zhangsw on 2017/10/19.
 */
public class ExcelSheetColumnTitle
{
	class Solution
	{
		public String convertToTitle(int n)
		{
			StringBuilder stringBuilder = new StringBuilder();
			while (n > 0)
			{
				stringBuilder.append((char) ((n - 1) % 26 + 'A'));
				n = (n - 1) / 26;
				//下标从1开始而不是从0，所以作减1操作
			}
			return stringBuilder.reverse().toString();
		}
	}
}
