package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangsw on 2017/11/9.
 */
public class RansomNote
{
	class Solution
	{
		public boolean canConstruct(String ransomNote, String magazine)
		{
			Map<Character, Integer> store = new HashMap<>();
			for (int i = 0, len = magazine.length(); i < len; ++i)
			{
				if (!store.containsKey(magazine.charAt(i)))
				{
					store.put(magazine.charAt(i), 1);
				}
				else
				{
					store.put(magazine.charAt(i), store.get(magazine.charAt(i)) + 1);
				}
			}
			for (int i = 0, len = ransomNote.length(); i < len; ++i)
			{
				if (store.containsKey(ransomNote.charAt(i)) && store.get(ransomNote.charAt(i)) > 0)
				{
					store.put(ransomNote.charAt(i), store.get(ransomNote.charAt(i)) - 1);
				}
				else
				{
					return false;
				}
			}
			return true;
		}

		//上面的解法可以用数组简化
		/*
		public boolean canConstruct(String ransomNote, String magazine)
		{
			int[] arr = new int[26];
			for (int i = 0; i < magazine.length(); i++)
			{
				arr[magazine.charAt(i) - 'a']++;
			}
			for (int i = 0; i < ransomNote.length(); i++)
			{
				if (--arr[ransomNote.charAt(i) - 'a'] < 0)
				{
					return false;
				}
			}
			return true;
		}
		*/
	}
}
