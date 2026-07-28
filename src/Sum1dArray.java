public class Sum1dArray {
      
      private static void sumArray(int[] a){
            
            for(int i = 1; i < a.length;i++){
                  a[i]+=a[i-1];
            }
      }
      
      public static void main(String[] args){
            
            int[] arr = {3,1,2,10};
            
            sumArray(arr);
            
            for (int j : arr) {
                  System.out.print(j + " ");
            }
      }
}