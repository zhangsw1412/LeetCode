package leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhangsw on 2017/12/8.
 */
public class BaseballGame
{
	class Solution
	{
		public int calPoints(String[] ops)
		{
			int sum = 0;
			LinkedList<Integer> list = new LinkedList<>();
			for (String s : ops)
			{
				switch (s)
				{
					case "C":
						sum -= list.removeLast();
						break;
					case "D":
						list.add(list.peekLast() * 2);
						sum += list.peekLast();
						break;
					case "+":
						list.add(list.peekLast() + list.get(list.size() - 2));
						sum += list.peekLast();
						break;
					default:
						list.add(Integer.parseInt(s));
						sum += list.peekLast();
				}
			}
			return sum;
		}
	}
}
