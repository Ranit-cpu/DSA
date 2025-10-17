package codevita;

import java.util.*;

public class HybridBanana {
      static class State implements Comparable<State> {
            int node, tree, cost;
            State(int n, int t, int c) { node = n; tree = t; cost = c; }
            public int compareTo(State o) { return this.cost - o.cost; }
      }
      
      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt(); sc.nextLine();
            
            Map<Integer, List<Integer>> graph = new HashMap<>();
            Map<Integer, Integer> parent = new HashMap<>();
            Map<Integer, List<Integer>> nodeToTrees = new HashMap<>();
            
            int treeId = 0;
            for (int i = 0; i < N; i++) {
                  String line = sc.nextLine().trim();
                  if (line.equals("break")) { treeId++; continue; }
                  
                  String[] parts = line.split(" ");
                  int root = Integer.parseInt(parts[0]);
                  
                  nodeToTrees.computeIfAbsent(root, k -> new ArrayList<>()).add(treeId);
                  
                  for (int j = 1; j < parts.length; j++) {
                        int child = Integer.parseInt(parts[j]);
                        graph.computeIfAbsent(root, k -> new ArrayList<>()).add(child);
                        graph.computeIfAbsent(child, k -> new ArrayList<>()).add(root);
                        parent.put(child, root);
                        nodeToTrees.computeIfAbsent(child, k -> new ArrayList<>()).add(treeId);
                  }
            }
            
            int start = sc.nextInt();
            int dest = sc.nextInt();
            
            // Priority Queue for Dijkstra (min energy)
            PriorityQueue<State> pq = new PriorityQueue<>();
            Map<String, Integer> dist = new HashMap<>();
            
            for (int t : nodeToTrees.get(start)) {
                  String key = start + "," + t;
                  dist.put(key, 0);
                  pq.add(new State(start, t, 0));
            }
            
            int ans = Integer.MAX_VALUE;
            
            while (!pq.isEmpty()) {
                  State cur = pq.poll();
                  String key = cur.node + "," + cur.tree;
                  
                  if (cur.cost > dist.get(key)) continue;
                  if (cur.node == dest) {
                        ans = cur.cost;
                        break;
                  }
                  
                  // Explore neighbors
                  for (int nb : graph.getOrDefault(cur.node, Collections.emptyList())) {
                        int cost = cur.cost;
                        if (parent.get(nb) != null && parent.get(nb) == cur.node) {
                              // moving down -> cost 0
                              cost += 0;
                        } else if (parent.get(cur.node) != null && parent.get(cur.node) == nb) {
                              // moving up -> cost 1
                              cost += 1;
                        }
                        
                        String nbKey = nb + "," + cur.tree;
                        if (cost < dist.getOrDefault(nbKey, Integer.MAX_VALUE)) {
                              dist.put(nbKey, cost);
                              pq.add(new State(nb, cur.tree, cost));
                        }
                  }
                  
                  // Switching trees at same node
                  for (int t2 : nodeToTrees.getOrDefault(cur.node, Collections.emptyList())) {
                        if (t2 != cur.tree) {
                              int cost = cur.cost + 1;
                              String swKey = cur.node + "," + t2;
                              if (cost < dist.getOrDefault(swKey, Integer.MAX_VALUE)) {
                                    dist.put(swKey, cost);
                                    pq.add(new State(cur.node, t2, cost));
                              }
                        }
                  }
            }
            
            System.out.println(ans);
      }
}

