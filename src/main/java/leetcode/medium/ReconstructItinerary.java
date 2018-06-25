package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by zhangsw on 2018/6/25.
 */
public class ReconstructItinerary
{
    class Solution
    {
        public List<String> findItinerary(String[][] tickets)
        {
            Map<String, PriorityQueue<String>> graph = new HashMap<>();
            for (String[] ticket : tickets)
            {
                PriorityQueue<String> destination = graph.get(ticket[0]);
                if (destination == null)
                {
                    destination = new PriorityQueue<>();
                    graph.put(ticket[0], destination);
                }
                destination.offer(ticket[1]);
            }
            ArrayList<String> itinerary = new ArrayList<>();
            find("JFK", itinerary, graph);
            return itinerary;
        }

        private void find(String depart, ArrayList<String> itinerary, Map<String, PriorityQueue<String>> graph)
        {
            PriorityQueue<String> destination = graph.get(depart);
            while (destination != null && !destination.isEmpty())
            {
                find(destination.poll(), itinerary, graph);
            }
            itinerary.add(0, depart);
        }
    }
}
