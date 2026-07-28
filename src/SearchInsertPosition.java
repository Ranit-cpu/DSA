public class SearchInsertPosition {

    public static void main(String[] args){
        int[] arr = {1,2,4,5,7};
        int x = 6;
        int index = binarySearchInsertPosition(arr,x);

        System.out.println("The insert index is = "+index);
    }

    private static int binarySearchInsertPosition(int[] arr, int x){
        int n = arr.length;
        int low = 0, high = n-1;
        int index  = n;

        while(low<=high){
            int mid = (low + high)/2;

            if(arr[mid] >= x){
                index = mid;
                high = mid -1;
            }else {
                low = mid +1;
            }
        }
        return index;
    }
}
