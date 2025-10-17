package codevita;

import java.util.*;

public class BusCount {
      
      static int N, capacity;
      static int[][] graph;
      static int[] employees, parent;
      static int buses = 0; // global counter
      
      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            
            // number of locations (including office)
            N = sc.nextInt();
            graph = new int[N][N];
            
            // read distance matrix
            for (int i = 0; i < N; i++) {
                  for (int j = 0; j < N; j++) {
                        graph[i][j] = sc.nextInt();
                  }
            }
            
            // read employees (skip office index 0)
            employees = new int[N];
            for (int i = 1; i < N; i++) {
                  employees[i] = sc.nextInt();
            }
            
            // bus capacity
            capacity = sc.nextInt();
            
            parent = new int[N];
            Arrays.fill(parent, -1);
            
            // build shortest path tree
            dijkstra();
            
            // build adjacency list tree from parent array
            List<List<Integer>> tree = new ArrayList<>();
            for (int i = 0; i < N; i++) tree.add(new ArrayList<>());
            for (int i = 1; i < N; i++) {
                  tree.get(parent[i]).add(i);
            }
            
            // run DFS from office
            collectBuses(0, tree);
            
            // final answer
            System.out.println(buses);
      }
      
      // Dijkstra from office (node 0)
      static void dijkstra() {
            int[] dist = new int[N];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[0] = 0;
            
            boolean[] visited = new boolean[N];
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            pq.offer(new int[]{0, 0}); // {node, distance}
            
            while (!pq.isEmpty()) {
                  int[] cur = pq.poll();
                  int u = cur[0];
                  if (visited[u]) continue;
                  visited[u] = true;
                  
                  for (int v = 0; v < N; v++) {
                        if (graph[u][v] > 0 && dist[u] + graph[u][v] < dist[v]) {
                              dist[v] = dist[u] + graph[u][v];
                              parent[v] = u;
                              pq.offer(new int[]{v, dist[v]});
                        }
                  }
            }
      }
      
      // DFS: return leftover people from subtree of u
      static int collectBuses(int u, List<List<Integer>> tree) {
            int people = employees[u];
            
            for (int child : tree.get(u)) {
                  people += collectBuses(child, tree);
            }
            
            if (u != 0) { // if not office
                  buses += people / capacity;     // full buses
                  people = people % capacity;     // leftover passed to parent
            }
            return people;
      }
}
