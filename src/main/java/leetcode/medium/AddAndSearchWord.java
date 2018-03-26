package leetcode.medium;

/**
 * Created by zhangsw on 2018/3/26.
 */
public class AddAndSearchWord
{
	class WordDictionary
	{

		class TrieNode
		{
			TrieNode[] children = new TrieNode[26];
			boolean isWord;
		}

		private TrieNode root = new TrieNode();

		public WordDictionary()
		{

		}

		// Adds a word into the data structure.
		public void addWord(String word)
		{
			TrieNode node = root;
			for (char c : word.toCharArray())
			{
				if (node.children[c - 'a'] == null)
				{
					node.children[c - 'a'] = new TrieNode();
				}
				node = node.children[c - 'a'];
			}
			node.isWord = true;
		}

		// Returns if the word is in the data structure. A word could
		// contain the dot character '.' to represent any one letter.
		public boolean search(String word)
		{
			return match(word.toCharArray(), 0, root);
		}

		private boolean match(char[] chs, int k, TrieNode node)
		{
			if (k == chs.length)
			{
				return node.isWord;
			}
			if (chs[k] == '.')
			{
				for (int i = 0; i < node.children.length; i++)
				{
					if (node.children[i] != null && match(chs, k + 1, node.children[i]))
					{
						return true;
					}
				}
			}
			else
			{
				return node.children[chs[k] - 'a'] != null && match(chs, k + 1, node.children[chs[k] - 'a']);
			}
			return false;
		}
	}
}
