package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangsw on 2018/4/18.
 */
public class BullsAndCows
{
	class Solution
	{
		public String getHint(String secret, String guess)
		{
			if (secret == null || secret.length() == 0 || guess == null || guess.length() == 0)
			{
				return "0A0B";
			}
			List<Character> secretList = new ArrayList<>(), guessList = new ArrayList<>();
			int same = 0, different = 0, counter = 0;
			for (; counter < Math.min(secret.length(), guess.length()); ++counter)
			{
				if (secret.charAt(counter) == guess.charAt(counter))
				{
					++same;
				}
				else
				{
					secretList.add(secret.charAt(counter));
					guessList.add(guess.charAt(counter));
				}
			}
			while (counter < secret.length())
			{
				secretList.add(secret.charAt(counter++));
			}
			while (counter < guess.length())
			{
				guessList.add(guess.charAt(counter++));
			}
			for (Character character : guessList)
			{
				if (secretList.contains(character))
				{
					different++;
					secretList.remove(character);
				}
			}
			return same + "A" + different + "B";
		}

		//一次遍历版
		/*
		public String getHint(String secret, String guess)
		{
			int bulls = 0;
			int cows = 0;
			int[] numbers = new int[10];
			for (int i = 0; i < secret.length(); i++)
			{
				int s = Character.getNumericValue(secret.charAt(i));
				int g = Character.getNumericValue(guess.charAt(i));
				if (s == g)
				{
					bulls++;
				}
				else
				{
					if (numbers[s] < 0)
					{
						cows++;
					}
					if (numbers[g] > 0)
					{
						cows++;
					}
					numbers[s]++;
					numbers[g]--;
				}
			}
			return bulls + "A" + cows + "B";
		}
		*/
	}
}
