public class MergeSortedArrayWS {

    public static void merge(long[] arr1, long[] arr2, int n, int m){
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
    }

    public static void main(String[] args){

        long[] arr1 = {1,3,5,7};
        long[] arr2 = {0,2,6,8,9};

        merge(arr1,arr2, arr1.length, arr2.length);
    }
}
