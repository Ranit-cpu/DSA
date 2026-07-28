// Implement Lower Bound

public class LowerBound {
      
      private static int lowerBound(int x, int[] arr){
            
            for (int i = 0; i < arr.length; i++) {
                  if(arr[i] >= x){
                        return i;
                  }
            }
            return -1;
      }
      
      public static void main(String[] args){
            
            int[] arr = {1,2,2,4,8,9,11,13};
            
            int i =lowerBound(10, arr);
            
            if(i == -1){
                  System.out.println("Element not in the Array.");
            } else {
                  System.out.println(i+" is the Lower Bound.");
            }
            
      }
}
