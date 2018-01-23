package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zhangsw on 2018/1/23.
 */
public class CloneGraph
{
	/**
	 * Definition for undirected graph.
	 */
	class UndirectedGraphNode
	{
		int label;
		List<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x)
		{
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	}

	class Solution
	{
		//深度优先遍历
		private HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();

		public UndirectedGraphNode cloneGraph(UndirectedGraphNode node)
		{
			return clone(node);
		}

		private UndirectedGraphNode clone(UndirectedGraphNode node)
		{
			if (node == null)
			{
				return null;
			}

			if (map.containsKey(node.label))
			{
				return map.get(node.label);
			}
			UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
			map.put(clone.label, clone);
			for (UndirectedGraphNode neighbor : node.neighbors)
			{
				clone.neighbors.add(clone(neighbor));
			}
			return clone;
		}
	}
}
