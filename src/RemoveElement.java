public class RemoveElement {
      
      private static int remove(int[] a, int val){
            int k = 0;
            for(int j:a){
                  if(j!=val){
                        a[k]=j;
                        k++;
                  }
            }
            return k;
      }
      
      public static void main(String[] args){
            int[] a = {3,1,2,6,3,8,5,3,9};
            int val = 3;
            
            System.out.println("Before Removing :");
            for (int j : a) {
                  System.out.print(j + " ");
            }
            System.out.println();
            
            int k = remove(a,val);
            
            System.out.println("After Removing "+val+":");
            for(int i = 0; i < k; i++){
                  System.out.print(a[i]+" ");
            }
      }
}