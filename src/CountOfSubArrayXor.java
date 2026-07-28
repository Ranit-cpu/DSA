import java.util.HashMap;
import java.util.Map;

public class CountOfSubArrayXor
{
      public static void main(String[] args) {
            
            int[] arr = { 1, 1, 0, -2, -1, -1, 0, 1, -1};
            int max = xorCount(arr, arr.length);
            
            System.out.println("Length of longest subArray of sum Zero is = "+max);
      }
      
      private static int xorCount(int[] arr, int n){
            int count  = 0;
            Map<Integer, Integer> map = new HashMap<>();
            int xr = 0;
            
            map.put(xr,1);
            
            return count;
      }
}
