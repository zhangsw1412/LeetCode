package leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhangsw on 2017/12/14.
 */
public class GenerateParentheses
{
	class Solution
	{
		public List<String> generateParenthesis(int n)
		{
			List<String> list = new LinkedList<>();
			helper(0, 0, n, "", list);
			return list;
		}

		private void helper(int opened, int closed, int n, String pre, List<String> list)
		{
			if (opened == n && closed == n)
			{
				list.add(pre);
			}
			if (opened < n)
			{
				helper(opened + 1, closed, n, pre + "(", list);
			}
			if (closed < opened)
			{
				helper(opened, closed + 1, n, pre + ")", list);
			}
		}
	}
}
