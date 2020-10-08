package Leetcode.Reconstruct_Itinerary;

import java.util.*;

public class Solution {

    public static List<String> findItinerary(List<List<String>> tickets) {
        if (tickets == null || tickets.size() == 0) return null;
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            graph.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            graph.get(ticket.get(0)).offer(ticket.get(1));
        }
        List<String> itinerary = new ArrayList<>();
        dfs(graph, "JFK", itinerary);
        return itinerary;
    }

    private static void dfs(Map<String, PriorityQueue<String>> graph, String from, List<String> itinerary) {
        PriorityQueue<String> adjacents = graph.getOrDefault(from, new PriorityQueue<>());
        while (!adjacents.isEmpty()) {
            dfs(graph, adjacents.poll(), itinerary);
        }
        itinerary.add(0, from);
    }

    public static void main(String[] args){
        List<List<String>> in = new ArrayList<>();
        List<String> l = new ArrayList<>();
        l.add("MUC");
        l.add("LHR");
        in.add(l);
        List<String> l1 = new ArrayList<>();
        l1.add("JFK");
        l1.add("MUC");
        in.add(l1);
        List<String> l2 = new ArrayList<>();
        l2.add("SFO");
        l2.add("SJC");
        in.add(l2);
        List<String> l22 = new ArrayList<>();
        l22.add("SFO");
        l22.add("FFF");
        in.add(l22);
        List<String> l3 = new ArrayList<>();
        l3.add("LHR");
        l3.add("SFO");
        in.add(l3);
        List<String> ss = findItinerary(in);
        for(int i=0;i<ss.size();i++){
            System.out.println(ss.get(i));
        }
    }
}
