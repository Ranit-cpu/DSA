public class OccurenceInSortedArray {

    private static int firstOccurence(int[] arr, int n, int x){
        int low  = 0, high = n - 1;
        int first = -1;

        while(low<= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == x){
                first = mid;
                high = mid - 1;
            }else if(arr[mid] < x){
                low = mid + 1;
            }else{
                low = mid - 1;
            }
        }
        return first;
    }

    private static int lastOccurence(int[] arr, int n, int x){
        int low = 0, high = n -1;
        int last = -1;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == x){
                last = mid;
                low = mid + 1;
            }else if(arr[mid] < x){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return last;
    }

    private static int[] firstAndLastPosition(int[] arr, int n, int x){
        int first = firstOccurence(arr, n, x);
        if (first == -1) return new int[] { -1, -1};
        int last = lastOccurence(arr, n, x);
        return new int[] {first, last};
    }

    private static int count(int[] arr, int n, int x){
        int[] ans = firstAndLastPosition(arr,n,x);
        if(ans[0] == -1) return 0;
        return (ans[1] - ans[0] + 1);
    }

    public static void main(String[] args){
        int[] arr  = {2, 4, 6, 8, 8, 8, 11, 13};
        int n = arr.length, x = 8;
        int ans = count(arr,n,x);
        System.out.println("Count of "+x+" is = "+ans);
    }
}
