// Merge Sorted arrays without using extra space

public class MergeSortedArrayWS {

    /*Brute-force solution*/


/*    public static void merge(long[] arr1, long[] arr2, int n, int m){
        long[] arr3 = new long[m+n];

        int left = 0;
        int right = 0;
        int idx = 0;

        while (left < n && right < m){
            if(arr1[left] <= arr2[right]){
                arr3[idx] = arr1[left];
                left++;
                idx++;
            }
            else {
                arr3[idx] = arr2[right];
                right++;
                idx++;
            }

        }
        while (left < n){
            arr3[idx++] = arr1[left++];
        }
        while(right < m){
            arr3[idx++] = arr2[right++];
        }

        for (long num : arr3){
            System.out.print(num+" ");
        }
    }*/

    public static void merge(long[] arr1, long[] arr2, int n, int m){

        int gap = ((m+n)/2) + ((m+n)%2);

        while(gap > 0){
            int left = 0;
            int right = left+gap;

            while(right < (m+n)){
                //left is in array1 and right is in array2
                if(left < n && right >= n){
                    swapIfGreater(arr1, arr2, left,right-n);
                }
                //left and right is in array2
                else if (left >= n) {
                    swapIfGreater(arr1,arr2, left-n, right-n);
                }
                //left and right is in array1
                else {
                    swapIfGreater(arr1, arr2, left, right);
                }
                left++;
                right++;
            }
            if(gap == 1) break;
            gap = gap/2 + (gap %2);
        }

    }

    private static void swapIfGreater(long[] arr1, long[] arr2, int ind1, int ind2){
        if(arr1[ind1] > arr2[ind2]){
            long temp = arr1[ind1];
            arr1[ind1] = arr2[ind2];
            arr2[ind2] = temp;
        }
    }

    public static void main(String[] args){

        long[] arr1 = {1,3,5,7};
        long[] arr2 = {0,2,4,8,9};

        merge(arr1,arr2, arr1.length, arr2.length);

        System.out.print(" Merged Array: ");
        for (long num : arr1) System.out.print(num + " ");
        for (long num : arr2) System.out.print(num + " ");
    }
}