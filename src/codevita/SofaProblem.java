package codevita;

import java.util.*;

public class SofaProblem {
      
      static class State {
            int r1, c1, r2, c2, steps;
            
            State(int r1, int c1, int r2, int c2, int steps) {
                  this.r1 = r1;
                  this.c1 = c1;
                  this.r2 = r2;
                  this.c2 = c2;
                  this.steps = steps;
            }
            
            // Unique key for visited states
            String encode() {
                  if (r1 < r2 || (r1 == r2 && c1 < c2))
                        return r1 + "," + c1 + "," + r2 + "," + c2;
                  else
                        return r2 + "," + c2 + "," + r1 + "," + c1;
            }
      }
      
      static int M, N;
      static char[][] grid;
      static int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
      
      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            M = sc.nextInt();
            N = sc.nextInt();
            grid = new char[M][N];
            
            List<int[]> start = new ArrayList<>();
            List<int[]> target = new ArrayList<>();
            
            for (int i = 0; i < M; i++) {
                  for (int j = 0; j < N; j++) {
                        grid[i][j] = sc.next().charAt(0);
                        if (grid[i][j] == 's') start.add(new int[]{i,j});
                        if (grid[i][j] == 'S') target.add(new int[]{i,j});
                  }
            }
            
            int result = bfs(start, target);
            if (result == -1) System.out.println("Impossible");
            else System.out.println(result);
      }
      
      static int bfs(List<int[]> start, List<int[]> target) {
            Queue<State> q = new LinkedList<>();
            Set<String> visited = new HashSet<>();
            
            State init = new State(start.get(0)[0], start.get(0)[1],
                    start.get(1)[0], start.get(1)[1], 0);
            q.add(init);
            visited.add(init.encode());
            
            while (!q.isEmpty()) {
                  State cur = q.poll();
                  
                  // Check if sofa reached destination
                  if (matches(cur, target)) return cur.steps;
                  
                  // Try moving sofa in 4 directions
                  for (int[] d : dirs) {
                        int nr1 = cur.r1 + d[0], nc1 = cur.c1 + d[1];
                        int nr2 = cur.r2 + d[0], nc2 = cur.c2 + d[1];
                        if (valid(nr1,nc1) && valid(nr2,nc2)) {
                              State next = new State(nr1,nc1,nr2,nc2,cur.steps+1);
                              if (visited.add(next.encode())) q.add(next);
                        }
                  }
                  
                  // Try rotations (only when valid 2x2 block exists)
                  for (State next : rotations(cur)) {
                        if (visited.add(next.encode())) q.add(next);
                  }
            }
            return -1;
      }
      
      static boolean matches(State cur, List<int[]> target) {
            int r1 = target.get(0)[0], c1 = target.get(0)[1];
            int r2 = target.get(1)[0], c2 = target.get(1)[1];
            return (cur.r1==r1 && cur.c1==c1 && cur.r2==r2 && cur.c2==c2) ||
                    (cur.r1==r2 && cur.c1==c2 && cur.r2==r1 && cur.c2==c1);
      }
      
      static boolean valid(int r, int c) {
            return r>=0 && c>=0 && r<M && c<N && grid[r][c] != 'H';
      }
      
      static List<State> rotations(State cur) {
            List<State> list = new ArrayList<>();
            
            // check orientation
            boolean horizontal = (cur.r1 == cur.r2);
            boolean vertical = (cur.c1 == cur.c2);
            
            // If sofa is horizontal
            if (horizontal) {
                  int row = cur.r1;
                  int minC = Math.min(cur.c1, cur.c2);
                  // Check if 2x2 block below or above is free
                  if (row+1 < M && valid(row+1,minC) && valid(row+1,minC+1) && valid(row,minC) && valid(row,minC+1)) {
                        list.add(new State(row, minC, row+1, minC, cur.steps+1));
                        list.add(new State(row, minC+1, row+1, minC+1, cur.steps+1));
                  }
                  if (row-1 >= 0 && valid(row-1,minC) && valid(row-1,minC+1) && valid(row,minC) && valid(row,minC+1)) {
                        list.add(new State(row, minC, row-1, minC, cur.steps+1));
                        list.add(new State(row, minC+1, row-1, minC+1, cur.steps+1));
                  }
            }
            
            // If sofa is vertical
            if (vertical) {
                  int col = cur.c1;
                  int minR = Math.min(cur.r1, cur.r2);
                  // Check if 2x2 block right or left is free
                  if (col+1 < N && valid(minR,col+1) && valid(minR+1,col+1) && valid(minR,col) && valid(minR+1,col)) {
                        list.add(new State(minR, col, minR, col+1, cur.steps+1));
                        list.add(new State(minR+1, col, minR+1, col+1, cur.steps+1));
                  }
                  if (col-1 >= 0 && valid(minR,col-1) && valid(minR+1,col-1) && valid(minR,col) && valid(minR+1,col)) {
                        list.add(new State(minR, col, minR, col-1, cur.steps+1));
                        list.add(new State(minR+1, col, minR+1, col-1, cur.steps+1));
                  }
            }
            
            return list;
      }
}
