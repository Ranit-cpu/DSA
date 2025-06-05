import java.util.Arrays;

public class KadanesAlgorithm {
      public static void main(String[] args) {
      
            int[] arr =  {-2, -3, 4, -1, -2, 1, 5, -3};
            int max = findMaxSumSubArray(arr, arr.length);
            System.out.println(max);
      }
      
      private static int findMaxSumSubArray(int[] arr, int n){
            int max = Integer.MIN_VALUE;
            int sum = 0;
            int start =0, end = 0,s=0;
            
            for(int i = 0; i < n;i++){
                  sum+=arr[i];
                  
                  if(max < sum){
                        max = sum;
                        start = s;
                        end = i;
                  }
                  if(sum < 0){
                        sum = 0;
                        s=i+1;
                  }
            }
            
            System.out.println(Arrays.toString(Arrays.copyOfRange(arr, start, end)));
            
            return max;
      }
      
      
}
