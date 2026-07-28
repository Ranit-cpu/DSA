package codevita;

import java.util.*;

public class Main {
      
      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            
            String time = sc.next();
            String[] parts = time.split(":");
            int hour = Integer.parseInt(parts[0]) % 12;
            int minute = Integer.parseInt(parts[1]);
            
            int Q = sc.nextInt();
            int A = sc.nextInt();
            int B = sc.nextInt();
            int X = sc.nextInt();
            int Y = sc.nextInt();
            
            int[] queries = new int[Q];
            for (int i = 0; i < Q; i++) {
                  queries[i] = sc.nextInt();
            }
            
            int hourPos = hour * 30;
            int minutePos = minute * 6;
            
            int totalCost = 0;
            
            for (int target : queries) {
                  totalCost += solveQuery(hourPos, minutePos, target, A, B, X, Y);
            }
            
            System.out.println(totalCost);
      }
      
      private static int solveQuery(int hourPos, int minutePos, int target,
                                    int A, int B, int X, int Y) {
            int currentDiff = Math.abs(hourPos - minutePos);
            currentDiff = Math.min(currentDiff, 360 - currentDiff);
            
            if (currentDiff == target) return 0;
            
            int minCost = Integer.MAX_VALUE;
            
            minCost = Math.min(minCost, moveMinuteOnly(hourPos, minutePos, target, A, B, Y));
            
            for (int shift = -6; shift <= 6; shift++) {
                  if (shift == 0) continue;
                  
                  int newHourPos = ((hourPos + shift * 30) % 360 + 360) % 360;
                  
                  int hourMove = Math.abs(newHourPos - hourPos);
                  if (hourMove > 180) hourMove = 360 - hourMove;
                  
                  int costHourCW = hourMove * X * A;
                  int costHourCCW = hourMove * X * B;
                  
                  int moveMinCW = moveMinuteOnlyOpposite(newHourPos, minutePos, target, A, B, Y, true);
                  int moveMinCCW = moveMinuteOnlyOpposite(newHourPos, minutePos, target, A, B, Y, false);
                  
                  if (moveMinCW != Integer.MAX_VALUE) {
                        minCost = Math.min(minCost, costHourCCW + moveMinCW);
                  }
                  if (moveMinCCW != Integer.MAX_VALUE) {
                        minCost = Math.min(minCost, costHourCW + moveMinCCW);
                  }
            }
            
            return minCost == Integer.MAX_VALUE ? 0 : minCost;
      }
      
      private static int moveMinuteOnly(int hourPos, int minutePos, int target,
                                        int A, int B, int Y) {
            int minCost = Integer.MAX_VALUE;
            for (int deg = 0; deg < 360; deg++) {
                  int diff = Math.abs(hourPos - deg);
                  diff = Math.min(diff, 360 - diff);
                  
                  if (diff == target) {
                        int cw = (deg - minutePos + 360) % 360;
                        int ccw = (minutePos - deg + 360) % 360;
                        
                        int costCW = cw * Y * A;
                        int costCCW = ccw * Y * B;
                        
                        minCost = Math.min(minCost, Math.min(costCW, costCCW));
                  }
            }
            return minCost;
      }
      
      private static int moveMinuteOnlyOpposite(int hourPos, int minutePos, int target,
                                                int A, int B, int Y, boolean minuteCW) {
            int minCost = Integer.MAX_VALUE;
            for (int deg = 0; deg < 360; deg++) {
                  int diff = Math.abs(hourPos - deg);
                  diff = Math.min(diff, 360 - diff);
                  
                  if (diff == target) {
                        if (minuteCW) {
                              int cw = (deg - minutePos + 360) % 360;
                              int costCW = cw * Y * A;
                              minCost = Math.min(minCost, costCW);
                        } else {
                              int ccw = (minutePos - deg + 360) % 360;
                              int costCCW = ccw * Y * B;
                              minCost = Math.min(minCost, costCCW);
                        }
                  }
            }
            return minCost;
      }
}
