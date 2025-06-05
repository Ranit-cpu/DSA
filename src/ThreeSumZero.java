import java.util.*;

public class ThreeSumZero {
      
      private static List<List<Integer>> threeSome(int[] a, int target){
            
            List<List<Integer>> ans = new ArrayList<>();
            int n = a.length;
            
            Arrays.sort(a);
            
            for(int i = 0; i < n; i++){
                  
                  if(i !=0 && a[i] == a[i-1]){
                        continue;
                  }
                  
                  int j = i + 1;
                  int k = n - 1;
                  while(j < k){
                        int sum = a[i]+a[j]+a[k];
                        
                        if(sum < target){
                              j++;
                        } else if (sum>target) {
                              k--;
                        }else{
                              List<Integer> temp = Arrays.asList(a[i],a[j],a[k]);
                              ans.add(temp);
                              j++;
                              k--;
                              while (j < k && a[j] == a[j-1]){
                                    j++;
                              }
                              while (j < k && a[k] == a[k+1]){
                                    k--;
                              }
                        }
                  }
            }
            return ans;
      }
      
      public static void main(String[] args) {
            
            int[] arr = { -1, 0, 1, 2, -1, 6 , 4 ,1};
            int target = 5;
            List<List<Integer>> ans = threeSome(arr, target);
            
            for (List<Integer> it : ans) {
                  
                  System.out.print("[");
                  for (Integer i : it) {
                        
                        System.out.print(i + " ");
                  }
                  System.out.print("] ");
            }
            System.out.println();
      }
}
