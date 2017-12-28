package leetcode.medium;

import java.util.LinkedList;

/**
 * Created by zhangsw on 2017/12/28.
 */
public class SimplifyPath
{
	class Solution
	{
		public String simplifyPath(String path)
		{
			if (path == null || path.length() == 0)
			{
				return "";
			}
			LinkedList<String> queue = new LinkedList<>();
			for (String str : path.split("/"))
			{
				if (str.equals(".") || str.equals(""))
				{
					continue;
				}
				else if (str.equals(".."))
				{
					if (!queue.isEmpty())
					{
						queue.removeLast();
					}
				}
				else
				{
					queue.add(str);
				}
			}
			StringBuilder stringBuilder = new StringBuilder();
			for (String str : queue)
			{
				stringBuilder.append("/");
				stringBuilder.append(str);
			}

			return stringBuilder.length() == 0 ? "/" : stringBuilder.toString();
		}
	}
}
