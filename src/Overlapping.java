import java.util.*;

public class Overlapping {
      public static void main(String[] args){
            
            List<List<Integer>> input = new ArrayList<>();
            input.add(Arrays.asList(1, 3));
            input.add(Arrays.asList(2, 6));
            input.add(Arrays.asList(8, 10));
            input.add(Arrays.asList(15, 18));
            
            List<List<Integer>> result = merge(input);
            
            for(List<Integer> i :result){
                  System.out.println(i);
            }
      }
      
      public static List<List<Integer>> merge(List<List<Integer>> intervals) {
            
            Collections.sort(intervals,(a,b)->a.get(0) - b.get(0));
            
            List<List<Integer>> ans = new ArrayList<>();
            
            for (int i = 0 ;i< intervals.size();i++) {
                  int start = intervals.get(i).get(0);
                  int end = intervals.get(i).get(1);
                  
                  while (i + 1 < intervals.size() && intervals.get(i + 1).get(0) <= end) {
                        end = Math.max(end, intervals.get(i + 1).get(1));
                        i++;
                  }
                  
                  ans.add(Arrays.asList(start, end));
            }
            return ans;
      }
}