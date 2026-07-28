
public class CountInversion {
      
      
      //With Time Complexity O(n^2)
      //Brute Force
      private static int countInversionBrute(int[] arr){
            
            int count = 0;
            int n= arr.length;
            
            for (int i = 0; i < n-1; i++) {
                  for (int j = i+1; j < n; j++) {
                        
                        if (arr[i] > arr[j]){
                              count ++;
                        }
                  }
            }
            
            return count;
      }
      
      
      public static int merge(int[] arr, int low, int mid, int high) {
            
            // Temporary array
            int[] temp = new int[high - low + 1];
            
            // Starting indices of left and right halves
            int left = low;
            int right = mid + 1;
            int k = 0;
            
            int count = 0;
            
            // Merge elements in sorted order
            while (left <= mid && right <= high) {
                  if (arr[left] <= arr[right]) {
                        temp[k++] = arr[left++];
                  } else {
                        temp[k++] = arr[right++];
                        count += (mid - left + 1); // Count inversions
                  }
            }
            
            // Copy remaining elements of left half
            while (left <= mid) {
                  temp[k++] = arr[left++];
            }
            
            // Copy remaining elements of right half
            while (right <= high) {
                  temp[k++] = arr[right++];
            }
            
            // Copy back to original array
            for (int i = low; i <= high; i++) {
                  arr[i] = temp[i - low];
            }
            
            return count;
      }
      
      private static int countInverseOptimal(int[] arr, int low, int high){
            
            int count = 0;
            
            if (low >= high) return count;
            
            int mid = (low + high) / 2;
            
            //Counting Inversions in left half
            count += countInverseOptimal(arr,low,mid);
            
            //Counting Inversions in right half
            count += countInverseOptimal(arr,mid+1,high);
            
            //Counting while merging
            count += merge(arr,low,mid,high);
            
            return count;
      }
      
      public static void main(String[] args){
            int[] arr = {5,4,3,2,1};
            
            int inversionCountBrute = countInversionBrute(arr);
            int inversionCountOptimal = countInverseOptimal(arr,0,arr.length-1);
            
            System.out.println("Number of Inversions in the array are (Brute Force) = "+inversionCountBrute);
            System.out.println("Number of Inversions in the array are (Optimal) = "+inversionCountOptimal);
            
      }
}
