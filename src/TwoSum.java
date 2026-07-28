import java.util.Arrays;

public class TwoSum
{
      public static int twoSum(int n, int []arr, int target)
      {
            Arrays.sort(arr);
            
            int count = 0;
            int left = 0, right = n - 1;
            
            while (left < right) {
                  
                  int sum = arr[left] + arr[right];
                  
                  if (sum == target) {
                        count++;
                        left++;
                        right--;
                  } else if (sum < target) {
                        left++;
                  }
                  else
                        right--;
            }
            return count;
      }
      
      public static void main(String[] args) {
            int n = 4;
            int[] arr = {3,1,2,4};
            int target = 6;
            int ans = twoSum(n, arr, target);
            System.out.println("the number of subarrays are = " + ans);
            
      }
}