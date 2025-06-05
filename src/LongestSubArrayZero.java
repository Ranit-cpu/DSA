import java.util.HashMap;

public class LongestSubArrayZero {
      
      public static int maxLen(int[] arr, int n){
            int max = 0;
            HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
            int sum = 0;
            
            for(int i = 0 ; i < n ; i++){
                  sum+=arr[i];
                  
                  if(sum == 0){
                        max= i+1;
                  }
                  else{
                        if(map.get(sum)!=null){
                              max = Math.max(max,i - map.get(sum));
                        }
                        else{
                              map.put(sum,i);
                        }
                  }
            }
            
            return max;
      }
      
      public static void main(String[] args) {
            
            int[] arr = { 1, 1, 0, -2, -1, -1, 0, 1, -1};
            int max = maxLen(arr, arr.length);
            
            System.out.println("Length of longest subArray of sum Zero is = "+max);
      }
}
