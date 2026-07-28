package codevita;

import java.util.*;

public class BandsProblem {
      
      private static int S;
      private static char[][] g;
      
      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            
            // Read size
            if (!sc.hasNextInt()) {
                  // Defensive: if input is malformed
                  return;
            }
            S = sc.nextInt();
            sc.nextLine(); // consume newline
            
            g = new char[S][S];
            
            // Read S lines; be tolerant to stray blank lines/spaces
            int r = 0;
            while (r < S && sc.hasNextLine()) {
                  String line = sc.nextLine().replaceAll("\\s+", "");
                  if (line.isEmpty()) continue;        // skip blank lines
                  if (line.length() < S) continue;     // skip malformed short lines
                  for (int c = 0; c < S; c++) {
                        g[r][c] = line.charAt(c);
                  }
                  r++;
            }
            if (r < S) {
                  // Not enough rows; silently exit per contest norms
                  return;
            }
            
            // Scan for overlaps and track who is on top at each overlap cell
            int overlapCount = 0;
            boolean seenTop1 = false;
            boolean seenTop2 = false;
            
            for (int i = 0; i < S; i++) {
                  for (int j = 0; j < S; j++) {
                        char ch = g[i][j];
                        if (ch != '1' && ch != '2') continue;
                        
                        if (isOverlap(i, j)) {
                              overlapCount++;
                              if (ch == '1') seenTop1 = true;
                              else seenTop2 = true;
                        }
                  }
            }
            
            // Interlock rule:
            // If at least one overlap has '1' on top AND at least one has '2' on top,
            // the bands alternate over/under somewhere => cannot separate without cutting.
            if (overlapCount > 0 && seenTop1 && seenTop2) {
                  System.out.println("Impossible");
            } else {
                  System.out.println(overlapCount);
            }
      }
      
      // ---------- helpers ----------
      
      private static boolean in(int x, int y) {
            return x >= 0 && x < S && y >= 0 && y < S;
      }
      
      // Return the char at (x,y) or 0 if out-of-bounds
      private static char at(int x, int y) {
            return in(x, y) ? g[x][y] : 0;
      }
      
      /**
       * A cell (x,y) is an overlap if:
       *  - It is '1' or '2' (the TOP band at this crossing), and
       *  - Its own band is straight through this cell (either left&right or up&down),
       *  - The other band is straight through perpendicular to it (up&down or left&right).
       * Because corners never overlap (per problem), both bands must be straight at the crossing.
       */
      private static boolean isOverlap(int x, int y) {
            char top = g[x][y];
            if (top != '1' && top != '2') return false;
            char other = (top == '1') ? '2' : '1';
            
            boolean ownHoriz = at(x, y - 1) == top && at(x, y + 1) == top;
            boolean ownVert  = at(x - 1, y) == top && at(x + 1, y) == top;
            
            boolean othHoriz = at(x, y - 1) == other && at(x, y + 1) == other;
            boolean othVert  = at(x - 1, y) == other && at(x + 1, y) == other;
            
            // Must be perpendicular pairs: own horizontal + other vertical, or vice versa
            return (ownHoriz && othVert) || (ownVert && othHoriz);
      }
}
