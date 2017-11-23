package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangsw on 2017/11/23.
 */
public class KeyboardRow
{
	class Solution
	{
		//自己的版本
		public String[] findWords(String[] str)
		{
			List<String> list = new ArrayList<>();
			String[] keyboard = new String[]{"qwertyuiopQWERTYUIOP", "asdfghjklASDFGHJKL", "zxcvbnmZXCVBNM"};
			int row = 0;
			for (String s : str)
			{
				for (int i = 0; i < 3; ++i)
				{
					if (keyboard[i].indexOf(s.charAt(0)) != -1)
					{
						row = i;
					}
				}
				for (char c : s.toCharArray())
				{
					if (keyboard[row].indexOf(c) == -1)
					{
						row = -1;
						break;
					}
				}
				if (row != -1)
				{
					list.add(s);
				}
			}
			return list.toArray(new String[]{});
		}
	}
}
